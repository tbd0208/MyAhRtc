package com.example.myahrtc.domain;

public enum AuctionStatus {
	ENTRY_RECEIVED("출품접수"),
	APPRAISAL_COMPLETED("평가완료"),
	APPRAISAL_CONFIRMED("평가확정"),
	ENTRY_CONFIRMED("출품확정"),
	COMPLETING("완료중"),
	COMPLETED("완료"),
	ENDED("종료");

	private final String label;

	AuctionStatus(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
