package com.example.myahrtc.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class RtcProfitCalculator {

	public BigDecimal calculate(
			BigDecimal salePrice,
			BigDecimal totalBuyAmount,
			BigDecimal totalCost,
			BigDecimal taxAndFee) {

		return zero(salePrice)
				.subtract(zero(totalBuyAmount))
				.subtract(zero(totalCost))
				.subtract(zero(taxAndFee));
	}

	private BigDecimal zero(BigDecimal value) {
		return value == null ? BigDecimal.ZERO : value;
	}
}
