package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {
	
	
	
	public BlackjackHand () {}
	
	
	@Override
	public int getHandValue () {
//		add the values of each card in the hand
		int handValue = 0;
		
		for (Card card : hand) {
			handValue += card.getValue();
		}
		
		return handValue;
	}
	
	public boolean isBlackJack () {
//		true if the value of the cards in the hand is equal to 21
		boolean blackJack = false;
		
		if(getHandValue() == 21) {
			blackJack = true;
		}
		
		return blackJack;
	}
	
	public boolean isBust () {
//		true if the value of the cards in the hand is greater than 21
		boolean bust = false;
		
		if(getHandValue() > 21) {
			bust = true;
		}
		
		return bust;
	}
	
	public boolean isHard () {
//		if there is no ACE in the hand, the hand is hard
		boolean hard = true;
		
		for (Card card : hand) {
			if(card.getValue() == 11) {
				hard = false;
			}
		}
		
		return hard;		
	}
	
	public boolean isSoft () {
//		if there is an ACE in the hand, the hand is soft
		boolean soft = false;
		
		for (Card card : hand) {
			if(card.getValue() == 11) {
				soft = true;
			}
		}
		
		return soft;
	}

}
