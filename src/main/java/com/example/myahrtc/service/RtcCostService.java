package com.example.myahrtc.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.myahrtc.common.CmMap;
import com.example.myahrtc.dao.RtcCostDao;

@Service
public class RtcCostService {

	private final RtcCostDao rtcCostDao;

	public RtcCostService(RtcCostDao rtcCostDao) {
		this.rtcCostDao = rtcCostDao;
	}

	@Transactional(readOnly = true)
	public List<CmMap> getCostList(CmMap condition) {
		return rtcCostDao.selectCostList(condition);
	}

	@Transactional(readOnly = true)
	public BigDecimal getTotalCost(String carCd, String costTypeCd, String costTypeSubCd) {
		CmMap condition = new CmMap();
		condition.put("carCd", carCd);
		condition.put("costTypeCd", costTypeCd);
		condition.put("costTypeSubCd", costTypeSubCd);
		return rtcCostDao.selectTotalCost(condition);
	}
}
