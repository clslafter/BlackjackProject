package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Hand {

	List <Card> hand = new ArrayList<>();
	
	public Hand () {}
	
	public void addCard () {
//		gets a card from the deck and adds to hand
		Deck deck = new Deck();
		hand.add(deck.dealCard());
	}
	
	public void clear () {
//		?clears (?removes?) all cards from the hand?
//		Use iterator because we're removing the cards from the list
		Iterator<Card> it = hand.iterator();

		while (it.hasNext()) {
		  Card element = it.next();
		  hand.remove(0);
		}
	}
	
	public abstract int getHandValue ();

	@Override
	public String toString() {		
//		List the cards in the hand by Card name of Suit and Rank.

		String result = "";
		
		for (Card card : hand) {
			result += card.toString() + " ";
		}
		return result;
	}
	
	
}
