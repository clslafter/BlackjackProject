package com.skilldistillery.blackjack.entities;

public class Player {

	private String name;
	protected BlackjackHand BlackjackHand = new BlackjackHand();
	

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BlackjackHand getPlayerHand() {
		return BlackjackHand;
	}

	public void setPlayerHand(BlackjackHand playerHand) {
		this.BlackjackHand = playerHand;
	}
	
	public void ShowHand () {
//		calls the BlackjackHand toString to show the cards in the hand
		System.out.println("Player Hand: " + BlackjackHand.toString() + 
				"\nTotal: " + BlackjackHand.getHandValue()); 
		
	}
 }

