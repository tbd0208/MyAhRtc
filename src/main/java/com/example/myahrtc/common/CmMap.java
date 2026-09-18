package com.example.myahrtc.common;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

public class CmMap extends LinkedHashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	public String getString(String key) {
		Object value = get(key);
		return value == null ? "" : String.valueOf(value);
	}

	public BigDecimal getBigDecimal(String key) {
		Object value = get(key);
		if (value == null || "".equals(value)) {
			return BigDecimal.ZERO;
		}
		if (value instanceof BigDecimal) {
			return (BigDecimal) value;
		}
		return new BigDecimal(String.valueOf(value));
	}

	public boolean has(String key) {
		Object value = get(key);
		return value != null && !"".equals(String.valueOf(value).trim());
	}
}
