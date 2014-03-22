package com.br.drm.financeiroWeb.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AppCryptography {

	public static String encrypt(String text) throws AppException {

		try {
			MessageDigest md = MessageDigest.getInstance("SHA");

			byte[] shaCrip = md.digest(text.getBytes());

			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < shaCrip.length; i++) {
				int b = shaCrip[i] & 0xFF;
				buf.append(Integer.toHexString(b >> 4));
				buf.append(Integer.toHexString(b & 0xF));
			}

			return buf.toString();

		} catch (NoSuchAlgorithmException e) {
			throw new AppException(e.getMessage(), e);
		}

	}
}
