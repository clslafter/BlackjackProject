package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deck = new ArrayList<>(52);

	public Deck() {
		super();
		for(Rank rank : Rank.values()) {
			for(Suit suit : Suit.values()) {
				deck.add(new Card(suit, rank));
			}
		}
		
//		System.out.println("Done creating " + deck.size());
	}
	
	public int cardsLeftInDeck () {
//		check size of deck
		return deck.size();
	}
	
	
	public Card dealCard () {
		return deck.remove(0);
	}
	
	public void dealCard (Hand hand) {
//		when a card is dealt, it must be placed in either the dealer's or the player's hand
		
		hand.addCard(deck.remove(0));
		
	}
	
	public void shuffle () {
		Collections.shuffle(deck);
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}
	
	
}
