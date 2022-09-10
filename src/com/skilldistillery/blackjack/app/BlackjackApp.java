package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {

	public static void main(String[] args) {
//		Create a scanner for user input
		Scanner sc = new Scanner(System.in);

		// Instantiate new Black Jack Game
		BlackjackApp bja = new BlackjackApp();
//		play game
		bja.playBlackJack(sc);

	}

	private void playBlackJack(Scanner sc) {
		// there is a Dealer and a Player
		Dealer dealer = new Dealer();
		Player player = new Player();
		boolean isRunning = true;

		while (isRunning) {
			// The dealer deals the initial hand.
			dealer.dealFirstHand(player.getPlayerHand(), dealer.getPlayerHand());
			// Show player hand
			player.ShowHand();
			// Show dealer second card
			dealer.ShowDealerFirstHand();
			// If the player or dealer is dealt 21, the round is over.
			if (player.getPlayerHand().isBlackJack()) {
				dealer.ShowHand();
				if (dealer.getPlayerHand().isBlackJack()) {
					System.out.println("It's a tie! The round is over");
					isRunning = endOfRound(sc, player, dealer);
					continue;
				} else {
					System.out.println("The Player wins! The round is over");
					isRunning = endOfRound(sc, player, dealer);
					continue;
				}
			}
//			Otherwise, it's the player's turn 
			
		}



//		If they both have 21, it's a tie. Round is still over. 

// 		The hand for the player is displayed, with hand value
//		The second card for the dealer is display. Second card value displayed.

//		The player is given a choice to hit or stay.
//		If the player hits, the dealer deals a new card to the player's hand, ...
//		...and the new hand and value are displayed.

//		If the player's hand equals 21 after a hit, and the dealer's hand is less than 21, ...
//		the player must stay.

//		When the player decides to stay, the dealer turns over his hidden card. ...
//		...and the hand and hand value are displayed.
//		The dealer MUST Hit if the hand Value is below 17. If the hand value is over 17, the dealer must stay.
//		If the dealer's hand is over 21, dealer busts.
//		
//		Optional ... if the dealer has an ace, and counting it as 11 would bring the total to 17 or more...
//		(but not over 21), the dealer must count the ace as 11 and stand.

//		When the dealer stands, determine the winner of the round by comparing hand values. If the player...
//		hand value is greater than the dealer's the player wins. Otherwise, the dealer wins.

//			isRunning = endOfRound(sc, player, dealer);
	}

//	Evaluate hands
	
	public void playersTurn () {
//	the player can choose to hit...
	boolean stay = false;
	
	while (!stay) {
		System.out.println("Would you like to hit or stay?");
		System.out.println("Y: Yes, N: No");
	}
			
		
//	as many times as they wish until they choose to stay.
//	If the player hand is over 21, player busts and round is over.
		
		
	}
//	dealersTurn method
//	
//	results method
//	
	public boolean endOfRound(Scanner sc, Player player, Dealer dealer) {
		player.getPlayerHand().clear();
		dealer.getPlayerHand().clear();
		
		return playAgain(sc, dealer);
	}

	//
	public boolean playAgain(Scanner sc, Dealer dealer) {
//		if less than 12 cards left, get a new deck and shuffle deck
		System.out.println("Would you like to play another round?");
		System.out.println("Y: Yes, N: No");

		String userInput = sc.nextLine();

		if (userInput.toUpperCase().startsWith("Y")) {

			if (dealer.getDeck().cardsLeftInDeck() < 12) {
				dealer.getNewDeck();
			}
		} else if (userInput.toUpperCase().startsWith("N")) {
			System.out.println("Thank you for playing BlackJack. Goodbye!");
			return false;
		} else {
			System.out.println("That's not a valid option.");
			System.out.println("Please choose \"Y\" for Yes or \"N\" for No");
		}
		return true;
	}
	
}
