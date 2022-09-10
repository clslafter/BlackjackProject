package com.skilldistillery.blackjack.entities;

public class Player {
// Is it better to define the field as a Hand or BlackjackHand?
	protected Hand playerHand = new BlackjackHand();
	
	public void hit () {
//		player chooses to have one more card dealt to him from the dealer's deck and added to his hand
//		what should this method return, if anything?
//		?If it's the dealer that has the deck and that deals the card to the player,
//		what should this method do?? Should the dealer have this method?
		
		
	}
	
	public void stay () {
//		player chooses to keep the cards in hand
//		what should this method return, if anything?

	}

	public Hand getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(Hand playerHand) {
		this.playerHand = playerHand;
	}
	
	
 }
