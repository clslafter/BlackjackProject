package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEARTS("Hearts"),
	SPADES("Spades"),
	CLUBS("Clubs"),
	DIAMONDS("Diamonds");
	
	private String name;
	
	private Suit (String suitName) {
		this.name = suitName;
	}
	
	
	
	public String getName() {
		return name;
	}



	@Override
	public String toString() {
		return name;
	}

	
	
}
