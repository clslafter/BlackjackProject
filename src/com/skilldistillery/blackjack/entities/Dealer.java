package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
//	dealer also has a hand. It's in his super class.
//	dealer has a deck of cards
	private Deck deck = new Deck();
	
	int numCardsToDeal = 2;
	
	public Dealer () {
		deck = new Deck();
		deck.shuffle();
	}
	
	public void getNewDeck () {
		deck = new Deck();
		deck.shuffle();
	}
	

	public Deck getDeck() {
		return deck;
	}

	public void dealFirstHand(Hand playerHand, Hand dealerHand) {
//	First hand to player, second hand to dealer, third to player, fourth to dealer.
		
		for (int i = 0; i < numCardsToDeal; i++) {
			deck.dealCard(playerHand);
			deck.dealCard(dealerHand);
			
		}
	}
	
	public void hit (Hand hand) {
//		player chooses to have one more card dealt to him from the dealer's deck and added to his hand

		deck.dealCard(hand);
		
	}
	
	
	public void ShowDealerFirstHand () {
//		Show second card in dealer Hand
		System.out.println("Dealer Hand: First card face down, " + BlackjackHand.getHand().get(1) +"\n" +
				"Total: " + BlackjackHand.getHand().get(1).getValue());
		
	}
 }
