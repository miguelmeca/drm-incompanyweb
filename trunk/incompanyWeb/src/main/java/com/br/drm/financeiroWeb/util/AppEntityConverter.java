package com.br.drm.financeiroWeb.util;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = AppEntity.class, value = "appEntity")
public class AppEntityConverter implements Converter {

	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue != null) {
			return this.getAttributesFrom(component).get(submittedValue);
		}
		return null;
	}

	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value != null && !"".equals(value)) {

			AppEntity entity = (AppEntity) value;
			
			if (entity.getCodigo() == null)
				return "";

			this.addAttribute(component, entity);

			Long id = entity.getCodigo();

			if (id != null) {
				return String.valueOf(id);
			}
		}

		return (String) value;
	}

	protected void addAttribute(UIComponent component, AppEntity appEntity) {
		String key = appEntity.getCodigo().toString();
		this.getAttributesFrom(component).put(key, appEntity);
	}

	protected Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}

}
