package com.br.drm.financeiroWeb.util;

public class AppException extends Exception {

	private static final long serialVersionUID = -5177640136821474101L;

	public AppException() {
		super();
	}

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(String message) {
		super(message);
	}

	public AppException(Throwable cause) {
		super(cause);
	}

}
