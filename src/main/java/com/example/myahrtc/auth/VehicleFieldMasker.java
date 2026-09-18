package com.example.myahrtc.auth;

import java.util.Arrays;
import java.util.List;

import com.example.myahrtc.common.CmMap;

public class VehicleFieldMasker {

	private static final List<String> PROTECTED_FIELDS = Arrays.asList(
			"buyChannelCd",
			"buyChannelNm",
			"buyPrice",
			"margin",
			"buyEmployeeId",
			"buyEmployeeNm"
	);

	public CmMap mask(CmMap source, boolean hideProtectedFields) {
		CmMap result = new CmMap();
		result.putAll(source);

		if (hideProtectedFields) {
			for (String field : PROTECTED_FIELDS) {
				result.remove(field);
			}
		}
		return result;
	}
}
