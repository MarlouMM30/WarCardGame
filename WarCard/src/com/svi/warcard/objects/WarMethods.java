package com.svi.warcard.objects;

import java.util.*;
import com.svi.warcard.enums.*;

public class WarMethods extends ArrayList<Card> {

	private static final long serialVersionUID = 1L;

	public void populate() {

		for (Suits suits : Suits.values()) {
			
			for (Rank rank : Rank.values()) {
				
				Card cards = new Card(rank.getRankValue(), rank.getRankIdentity(), suits.getSuitWeight(),
						suits.getSuitIdentity());
				
				this.add(cards);

			}
		}
	}

	public static ArrayList<Card> shuffleDeck(int numShuffles, ArrayList<Card> deck) {

		ArrayList<Card> shuffledDeck = new ArrayList<Card>();
		ArrayList<Card> sameDeck = new ArrayList<Card>();

		for (int i = 0; i < numShuffles; i++) {
			
			if (shuffledDeck.isEmpty()) {
				sameDeck = deck;

			} else {
				sameDeck = shuffledDeck;

			}

			shuffledDeck = new ArrayList<Card>();

			for (int j = 0; j < 26; j++) {
				
				int k = j + 26;
				shuffledDeck.add(sameDeck.get(j));
				shuffledDeck.add(sameDeck.get(k));

			}
		}

		return shuffledDeck;
	}

	public static void distributeCards(int numPlayers, List<Players> playersList, List<Card> deck) {

		while (!deck.isEmpty()){
			for (int i = 0; i < numPlayers; i++) {
				playersList.get(i).getHandCards().add(deck.get(0));
				deck.remove(0);
				if (deck.isEmpty()) {
					break;

				}
			}

		System.out.println("PLAYER'S INITIAL CARDS: \n");

		for (Players player : playersList) {
			Collections.reverse(player.getHandCards());
			System.out.println(player.getPlayerName() + player.getPlayerNumber() + " => " + player.getHandCards());
		}
	}
}
	public static List<Card> getTopCards(List<Players> playersList) {

		List<Card> topCardsList = new ArrayList<Card>();

		for (Players player : playersList) {
			topCardsList.add(player.getHandCards().get(0));
			player.getHandCards().remove(0);
		}

		return topCardsList;
	}

	public static boolean compareCards(Card card1, Card card2) {

		if (card1.getRankValue() == card2.getRankValue()) {
			return (card1.getSuitWeight() < card2.getSuitWeight());
		}

		return (card1.getRankValue() < card2.getRankValue());
	}

	public static int getHighestCard(List<Card> topCardsList) {

		int highestCardIndex = 0;

		for (int i = 1; i < topCardsList.size(); i++) {
			if (compareCards(topCardsList.get(highestCardIndex), topCardsList.get(i))) {
				highestCardIndex = i;
			}

		}

		System.out.println("\n" + topCardsList.get(highestCardIndex) + " is the HIGHEST!!!");
		System.out.println();
		
		return highestCardIndex;
	}

	public static void Game(List<Players> playersList, int numPlayers) {

		List<Card> topCardsList = new ArrayList<Card>();

		for (Players player : playersList) {
			System.out.println(player.getPlayerName() + player.getPlayerNumber() + " : " + player.getHandCards());
		}

		topCardsList = (ArrayList<Card>) WarMethods.getTopCards(playersList);
		System.out.println("\nTOP Cards: " + topCardsList);
		int highestCardIndex = getHighestCard(topCardsList);
		Collections.rotate(topCardsList, topCardsList.size() - highestCardIndex);
		playersList.get(highestCardIndex).getHandCards().addAll(topCardsList);
		topCardsList.clear();
		playersList.removeIf(players -> players.getHandCards().isEmpty());

	}
}
