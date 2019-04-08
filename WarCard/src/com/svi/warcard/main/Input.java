package com.svi.warcard.main;

import com.svi.warcard.enums.*;

public class Input {

	public static Rank getRank(String rankIdentity) {

		for (Rank ranks : Rank.values()) {
			if (ranks.getRankIdentity().equals(rankIdentity)) {

				return ranks;
			}
		}

		return null;
	}

	public static Suits getSuit(String suitIdentity) {

		for (Suits suits : Suits.values()) {
			if (suits.getSuitIdentity().equals(suitIdentity)) {

				return suits;
			}
		}

		return null;
	}
}
