package com.example.myahrtc.dao;

import java.math.BigDecimal;
import java.util.List;

import com.example.myahrtc.common.CmMap;

public interface RtcCostDao {

	List<CmMap> selectCostList(CmMap condition);

	BigDecimal selectTotalCost(CmMap condition);
}
