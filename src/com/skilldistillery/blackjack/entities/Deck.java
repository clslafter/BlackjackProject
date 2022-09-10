package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deck = new ArrayList<>();

	public Deck() {
		super();
		for(Rank rank : Rank.values()) {
			for(Suit suit : Suit.values()) {
				deck.add(new Card(suit, rank));
			}
		}
		
		System.out.println("Done creating " + deck.size());
	}
	
	public int cardsLeftInDeck () {
//		how is this supposed to be different than checkDeckSize?
		return deck.size();
	}
	
	public int checkDeckSize() {
		return deck.size();
		
	}
	
	public Card dealCard () {
		return deck.remove(0);
	}
	
	public void dealCard (Hand hand) {
//		what am I supposed to put here?
//		what is this method supposed to do?
		
	}
	
	public void shuffle () {
		Collections.shuffle(deck);
	}
}
