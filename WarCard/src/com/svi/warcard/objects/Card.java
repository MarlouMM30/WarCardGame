package com.svi.warcard.objects;

public class Card {

	private int rankValue, suitWeight, cardValue;
	private String rankIdentity, suitIdentity;

	public Card(int rankValue, String rankIdentity, int suitWeight, String suitIdentity) {
		this.rankValue = rankValue;
		this.rankIdentity = rankIdentity;
		this.suitWeight = suitWeight;
		this.suitIdentity = suitIdentity;
		this.cardValue = 4 * rankValue + 1 * suitWeight;
	}
	
	public int getRankValue() {
		return rankValue;
	}

	public void setRankValue(int rankValue) {
		this.rankValue = rankValue;
	}

	public int getSuitWeight() {
		return suitWeight;
	}

	public void setSuitWeight(int suitWeight) {
		this.suitWeight = suitWeight;
	}

	public String getRankIdentity() {
		return rankIdentity;
	}

	public void setRankIdentity(String rankIdentity) {
		this.rankIdentity = rankIdentity;
	}

	public String getSuitIdentity() {
		return suitIdentity;
	}

	public void setSuitIdentity(String suitIdentity) {
		this.suitIdentity = suitIdentity;
	}

	public int getCardValue() {
		return cardValue;
	}

	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}

	public String toString() {
		return (rankIdentity + " - " + suitIdentity);

	}

}