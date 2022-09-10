package com.skilldistillery.blackjack.app;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {

	public static void main(String[] args) {
		// Instantiate new Black Jack Game
		BlackjackApp bja = new BlackjackApp();
//		play game
		bja.playBlackJack();

		
	}

	private void playBlackJack() {
		// there is a Dealer and a Player
		Player dealer = new Dealer();
		Player player = new Player();
		
//		The dealer deals the initial hand. 
		
//		The first card to the player, face up.
//		The second card to the dealer, hidden (face down).
//		The third card to the player, face up.
//		The fourth card to the dealer, face up.
		
//		If the player or dealer is dealt 21, the game is over. Otherwise, the player can choose to hit...
//		as many times as they wish until they choose to stay.
		
// 		The hand for the player is displayed, with hand value
//		The second card for the dealer is display. No hand value displayed
		
//		The player is given a choice to hit or stay.
//		If the player hits, the dealer deals a new card to the player's hand, ...
//		...and the new hand and value are displayed.
		
//		If the player's hand equals 21 after a hit, and the dealer's hand is less than 21, ...
//		the player gets blackjack and wins the round.
		
		
//		When the player decides to stay, the dealer turns over his hidden card. ...
//		...and the hand and hand value are displayed.
//		The dealer MUST Hit if the hand Value is below 17. If the hand value is over 17, the dealer must stay.
//		If the dealer's hand equals 21 after a hit, the dealer wins.
//		Optional ... if the dealer has an ace, and counting it as 11 would bring the total to 17 or more...
//		(but not over 21), the dealer must count the ace as 11 and stand.
		
//		When the dealer stands, determine the winner of the round by comparing hand values. If the player...
//		hand value is greater than the dealer's the player wins. Otherwise, the dealer wins.
		
		
	}

}
