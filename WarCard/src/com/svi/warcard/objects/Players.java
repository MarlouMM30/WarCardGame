package com.svi.warcard.objects;

import java.util.ArrayList;
import java.util.List;

public class Players {

	private String playerName;
	private int playerNumber;
	private List<Card> HandCards;

	public Players(String playerName, int playerNumber) {
		this.playerName = playerName;
		this.playerNumber = playerNumber;
		this.HandCards = new ArrayList<Card>();

	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public List<Card> getHandCards() {
		return HandCards;
	}

	public void setHandCards(List<Card> handCards) {
		HandCards = handCards;
	}

}