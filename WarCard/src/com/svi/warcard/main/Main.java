package com.svi.warcard.main;

import java.util.*;
import java.io.*;
import com.svi.warcard.enums.*;
import com.svi.warcard.objects.*;

public class Main {

	public static void main(String[] args) throws IOException {

		System.out.println("WELCOME TO SVI WAR CARD GAME"); // Greetings
		System.out.println("\n       Are you ready? ");
		System.out.println("If YES, answer the following: ");

		Scanner input = new Scanner(System.in);
		int numShuffles = 0; // Number of Shuffles' initialization
		int numPlayers = 0; // Number of Players' initialization
		boolean falseInput = true;

		do {
			try {
				System.out.println("\nHow many players do you want? \n"); // Try statement for number of players
				numPlayers = input.nextInt();
				
				if (numPlayers < 2) { // Conditions for number of players
					System.out.println("ERROR! Oopps... :( \n Number of players must be greater than 2");
					falseInput = true;
				} else {
					System.out.println(numPlayers + " PLAYERS");
					falseInput = false;
				}
			}

			catch (InputMismatchException e) {
				System.out.println("\nERROR! ERR ERR ERR :( \nOnly valid integer is allowed"); // Catch statement if input is not an integer
																						
				input.nextLine();
			}

		} while (falseInput);

		falseInput = true;

		do {
			try {
				System.out.println("\nHow many shuffles do you want? "); // Try statement for number of shuffles									
				numShuffles = input.nextInt();

				if (numShuffles < 0) { // Conditions for number of shuffles
					falseInput = true;
					System.out.println(
							"\nERROR! Oopps... :( \nIt must be greater than zero(0)");
				} else if (numShuffles <= 10) {
					System.out.println("Go! " + numShuffles + " SHUFFLE(S)");
					falseInput = false;
				} else if (numShuffles <= 30) {
					System.out.println("WOW! 'O' " + numShuffles + " SHUFFLES");
					falseInput = false;
				} else {
					System.out.println("OMG! >.< " + numShuffles + " SHUFFLES");
					falseInput = false;
				}
			}

			catch (InputMismatchException e) {

				System.out.println("\nERROR! ERR ERR ERR :( \nOnly valid integer is allowed"); // Catch statement if input is not an integer
				input.nextLine();
				
			}

		} while (falseInput);

		input.close();
		
		// Creating deck of cards
		WarMethods deck = new WarMethods();
		
		try {
			Scanner scanner = new Scanner(new File("input.txt"));
			String[] lineText = scanner.nextLine().split(",");
			
			for (String otherText : lineText) {
				String token[] = otherText.split("-");
				Suits suit = Input.getSuit(token[0]);
				Rank rank = Input.getRank(token[1]);
				deck.add(new Card(rank.getRankValue(), rank.getRankIdentity(), suit.getSuitWeight(), suit.getSuitIdentity()));
			}
			
			scanner.close();
			
			System.out.println("\nINPUT FILE LOADED SUCCESSFULLY!!!");
			System.out.println("\nHere is the Initial Deck of Cards: \n");
			System.out.println(deck); //Displays the Initial Deck of Cards
			
		} catch (IOException e) {
			
			System.out.println("\nFILE NOT FOUND!!! >.<");
			System.out.println("\nDEFAULT DECK ACTIVATED!");
			deck.populate();  // Populate deck
			System.out.println("\nHere is the Default Initial Deck of Cards: \n"); // Display initial deck of cards
			for (Card cards : deck) {
				System.out.print(cards.getRankIdentity() + " of " + cards.getSuitIdentity() + " | "); // Displays the content of the deck
			}

			System.out.println();
			
		}	

		ArrayList<Card> shuffledDeck = WarMethods.shuffleDeck(numShuffles, deck); // Calling shuffled deck from methods															
		System.out.println("\nHere is the Shuffled Deck of Cards: \n");
		
		for (Card card : shuffledDeck) {
			System.out.print(card.getRankIdentity() + " - " + card.getSuitIdentity() + " || ");
		}

		System.out.println("\n");

		// Create Players
		List<Players> playersList = new ArrayList<>();
		for (int p = 0; p < numPlayers; p++) {
			playersList.add(new Players("PLAYER " + (p + 1)));
		}

		// Distribute Cards
		WarMethods.distributeCards(numPlayers, playersList, shuffledDeck);
		
		// Start Game
		System.out.println("\nSTART GAME!!!");
		int roundNum = 1;
		while (playersList.size() > 1) {
			System.out.println("\nROUND " + roundNum);
			WarMethods.GameStart(playersList, numPlayers);
			playersList.removeIf(players -> players.getHandCards().isEmpty());
			roundNum++;
			
		}
		// if player list size = 1 , then game is finished
		System.out.println("\nGAME OVER!!!");
		System.out.println("\nWINNER   ==>   " + playersList.get(0).getPlayerName() + "   Rounds: " + (roundNum - 1));
		for (Players player : playersList) {
			System.out.println("WINNER'S DECK : " + player.getHandCards());
		}
	 }
  }
