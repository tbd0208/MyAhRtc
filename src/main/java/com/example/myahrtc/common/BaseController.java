package com.example.myahrtc.common;

public abstract class BaseController {

	protected CmMap success(Object data) {
		CmMap result = new CmMap();
		result.put("success", true);
		result.put("data", data);
		return result;
	}

	protected CmMap failure(String message) {
		CmMap result = new CmMap();
		result.put("success", false);
		result.put("message", message);
		return result;
	}
}
