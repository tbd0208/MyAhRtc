package com.example.myahrtc.auth;

import com.example.myahrtc.common.CmMap;

public class RtcAccessPolicy {

	public CmMap toQueryCondition(DataScope scope, CmMap loginUser) {
		CmMap condition = new CmMap();
		condition.put("dataScope", scope.name());

		switch (scope) {
		case COMPANY:
			condition.put("companyCd", loginUser.get("companyCd"));
			break;
		case BIZ_DIVISION:
			condition.put("bizTopDptCd", loginUser.get("bizTopDptCd"));
			break;
		case DEPARTMENT:
			condition.put("dptCd", loginUser.get("dptCd"));
			break;
		case SELF:
			condition.put("userId", loginUser.get("userId"));
			break;
		case ALL:
		default:
			break;
		}
		return condition;
	}

	public boolean mustBlindBuyChannel(CmMap row, CmMap loginUser) {
		if ("Y".equals(loginUser.getString("AR_RTC_BUYCH_BLND"))) {
			return true;
		}
		return "Y".equals(row.getString("buyChannelBlindYn"));
	}
}
