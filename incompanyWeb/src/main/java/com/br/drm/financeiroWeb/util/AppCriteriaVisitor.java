package com.br.drm.financeiroWeb.util;

import org.hibernate.Criteria;

public interface AppCriteriaVisitor {

	void visitCriteria(Criteria criteria);
	
	void visitSubCriteria(String property, Criteria criteria);
}
