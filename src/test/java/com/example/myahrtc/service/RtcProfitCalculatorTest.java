package com.example.myahrtc.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class RtcProfitCalculatorTest {

	private final RtcProfitCalculator calculator = new RtcProfitCalculator();

	@Test
	public void calculateSubtractsBuyCostAndFee() {
		BigDecimal result = calculator.calculate(
				new BigDecimal("30000000"),
				new BigDecimal("25000000"),
				new BigDecimal("1000000"),
				new BigDecimal("500000"));

		assertEquals(new BigDecimal("3500000"), result);
	}

	@Test
	public void calculateTreatsNullAsZero() {
		BigDecimal result = calculator.calculate(
				new BigDecimal("100"),
				null,
				null,
				null);

		assertEquals(new BigDecimal("100"), result);
	}
}
