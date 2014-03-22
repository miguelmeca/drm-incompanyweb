package com.br.drm.financeiroWeb.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class AppService<T extends AppEntity> {

	@Inject
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public T findById(Long pk) throws AppException {
		return (T) entityManager.find(getTypeClass(), pk);
	}

	public void save(T entity) throws AppException {
		if (entity.getCodigo() == null)
			entityManager.persist(entity);
		else 
			entityManager.merge(entity);
	}

	public void update(T entity) throws AppException {
		entityManager.merge(entity);
	}

	public void delete(T entity) throws AppException {
		T entityForDelete = findById(entity.getCodigo());
		entityManager.remove(entityForDelete);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() throws AppException {
		return entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByParameters(T object) throws AppException {

		Criteria criteria = createCriteria(object, null);

		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findByParameters(T object, AppCriteriaVisitor visitor) throws AppException {

		Criteria criteria = createCriteria(object, visitor);
		
		if (visitor != null) {
			visitor.visitCriteria(criteria);
		}

		return criteria.list();
	}

	private Class<?> getTypeClass() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return clazz;
	}

	private Criteria createCriteria(T object, AppCriteriaVisitor visitor) throws AppException {

		Criteria criteria = getSession().createCriteria(object.getClass());

		if (object.getCodigo() != null) {
			criteria.add(Restrictions.idEq(object.getCodigo()));
		} else {

			Example example = createExample(object);

			criteria.add(example);

			createSubCriteria(criteria, object, visitor);
		}

		return criteria;
	}

	private void createSubCriteria(Criteria criteria, AppEntity object, AppCriteriaVisitor visitor) throws AppException {

		try {

			PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(object);

			for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {

				Method method = propertyDescriptor.getReadMethod();

				if (method != null && (method.isAnnotationPresent(ManyToOne.class) || method.isAnnotationPresent(OneToOne.class))) {

					String propertyName = propertyDescriptor.getName();

					Object sub = PropertyUtils.getProperty(object, propertyName);

					if (sub != null && sub instanceof AppEntity) {

						Criteria subCriteria = null;

						subCriteria = criteria.createCriteria(propertyName);

						Long id = ((AppEntity) sub).getCodigo();

						if (id != null) {
							subCriteria.add(Restrictions.idEq(id));
						} else {

							Example ex = createExample(sub);

							subCriteria.add(ex);
							
							if (visitor != null) {
								visitor.visitSubCriteria(propertyName,
										subCriteria);
							}

							createSubCriteria(subCriteria, (AppEntity) sub, visitor);
						}
					}

				}
			}

		} catch (Exception e) {
			throw new AppException(e);
		}
	}

	private Example createExample(Object object) {

		Example example = Example.create(object).excludeZeroes().enableLike(MatchMode.ANYWHERE).ignoreCase();

		PropertySelector notNullOrEmptySelector = new PropertySelector() {

			private static final long serialVersionUID = 3872103103165444592L;

			public boolean include(Object object, String propertyName, org.hibernate.type.Type type) {
				return object != null && (!(object instanceof String) || !((String) object).equals(""));
			}
		};

		example.setPropertySelector(notNullOrEmptySelector);

		return example;

	}

	private Session getSession() {
		Session session = (Session) getEntityManager().getDelegate();
		return session;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
