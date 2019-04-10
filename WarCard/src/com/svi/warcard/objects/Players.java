package com.svi.warcard.objects;

import java.util.ArrayList;
import java.util.List;

public class Players {

	private String playerName;
	private List<Card> HandCards;

	public Players(String playerName) {
		this.playerName = playerName;
		this.HandCards = new ArrayList<Card>();

	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public List<Card> getHandCards() {
		return HandCards;
	}

	public void setHandCards(List<Card> handCards) {
		HandCards = handCards;
	}

}
