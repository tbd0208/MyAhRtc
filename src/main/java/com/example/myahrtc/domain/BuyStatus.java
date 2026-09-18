package com.example.myahrtc.domain;

public enum BuyStatus {
	REGISTERED("등록"),
	REMITTANCE_REQUESTED("송금요청"),
	CONFIRMED("매입확정"),
	CANCELLED("취소");

	private final String label;

	BuyStatus(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
