package com.svi.warcard.enums;

public enum Suits {
	DIAMONDS(4, "D"), HEARTS(3, "H"), SPADES(2, "S"), CLUBS(1, "C");

	private final int suitWeight;
	private final String suitIdentity;

	private Suits(int suitWeight, String suitIdentity) {
		this.suitWeight = suitWeight;
		this.suitIdentity = suitIdentity;
	}

	public int getSuitWeight() {
		return suitWeight;
	}

	public String getSuitIdentity() {
		return suitIdentity;
	}

}
