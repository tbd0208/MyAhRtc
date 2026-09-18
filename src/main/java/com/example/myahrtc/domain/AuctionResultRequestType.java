package com.example.myahrtc.domain;

public enum AuctionResultRequestType {
	WIN_CONFIRMATION("낙찰확정요청"),
	RE_ENTRY("재출품"),
	RETURN("반납");

	private final String label;

	AuctionResultRequestType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
