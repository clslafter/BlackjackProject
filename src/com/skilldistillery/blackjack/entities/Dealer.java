package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
//	dealer also has a hand. It's in his super class.
//	dealer has a deck of cards
	private Deck deck = new Deck();

	public Deck getDeck() {
		return deck;
	}

	public void dealHand() {
//	?should there be a return type for this method?

		super.playerHand.addCard();
	}
	
//	?should the dealer have his own hit and stay methods, since he is the one with the deck?
//	if so, should the player, as the parent class have hit and stay methods, at all?
//	?When the player hits, the dealer should deal the card from his deck to the player's hand, right?
}
