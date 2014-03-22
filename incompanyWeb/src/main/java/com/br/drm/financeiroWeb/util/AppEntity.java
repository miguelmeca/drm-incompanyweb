package com.br.drm.financeiroWeb.util;

import java.io.Serializable;

public abstract class AppEntity implements Serializable {

	private static final long serialVersionUID = -2426297005110989046L;

	public abstract Long getCodigo();

	public abstract void setCodigo(Long codigo);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getCodigo() == null) ? 0 : getCodigo().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!this.getClass().isAssignableFrom(obj.getClass())) {
			return false;
		}
		if (getCodigo() != null && obj instanceof AppEntity) {
			return getCodigo().equals(((AppEntity) obj).getCodigo());
		} else {
			return super.equals(obj);
		}
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "[codigo=" + getCodigo() + "]";
	}

}
