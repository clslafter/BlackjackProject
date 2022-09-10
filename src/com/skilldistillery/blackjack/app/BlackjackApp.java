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
			System.out.print("Player's ");
			player.showHand();
			System.out.println();
			// Show dealer second card
			dealer.ShowDealerFirstHand();
			System.out.println();
			// If the player or dealer is dealt 21, the round is over.
			if (player.getPlayerHand().isBlackJack()) {
				dealer.showHand();
				if (dealer.getPlayerHand().isBlackJack()) {
					System.out.println("It's a tie! The round is over");
					System.out.println();
					isRunning = endOfRound(sc, player, dealer);
					continue;
				} else {
					System.out.println("Blackjack. The Player wins! The round is over");
					System.out.println();
					isRunning = endOfRound(sc, player, dealer);
					continue;
				}
			} // playerHand isBlackjack curly brace
//			Otherwise, it's the player's turn 
			boolean notBust = playersTurn(sc, player, dealer);

//			If the player's turn returned Bust, end of Round
			if (!notBust) {
				isRunning = endOfRound(sc, player, dealer);
				continue;
			}

//			Dealer's turn
			boolean dealerNotBust = dealersTurn(dealer);

//			If the dealer's turn returned Bust, end of Round
			if (!dealerNotBust) {
				isRunning = endOfRound(sc, player, dealer);
				continue;
			}

//			Evaluate hands
			evaluateHand(player, dealer);
			isRunning = endOfRound(sc, player, dealer);
			continue;
		} // playGame isRunning curly brace

	} // playGame method curly brace

	public boolean playersTurn(Scanner sc, Player player, Dealer dealer) {
//	the player can choose to hit...
		boolean stay = false;
//		as many times as they wish until they choose to stay.
		while (!stay) {
//			The player is given a choice to hit or stay.
			System.out.println("Would you like to hit?");
			System.out.println("Y: Hit, N: Stay");
			System.out.println();

			String userInput = sc.nextLine();

			if (userInput.toUpperCase().startsWith("Y") || userInput.toUpperCase().startsWith("H")) {
//				If the player hits, the dealer deals a new card to the player's hand, ...
//				...and the new hand and value are displayed.
				System.out.println("You have chosen to hit.");
				System.out.println();
				dealer.hit(player.getPlayerHand());
				System.out.print("Player's ");
				player.showHand();
				System.out.println();
//				if the player's hand is 21, the player must stay
				if (player.getPlayerHand().isBlackJack()) {
					System.out.println("You have 21. Player stays.");
					System.out.println();
					stay = true;
				} else if (player.getPlayerHand().isBust()) {
//				If the player hand is over 21, player busts and round is over.
					System.out.println("Your hand is over 21. Bust! Player loses. The round is over");
					System.out.println();
					return false;
				}
//					

			} else if (userInput.toUpperCase().startsWith("N") || userInput.toUpperCase().startsWith("S")) {
				System.out.println("You have chosen to stay. It's the dealer's turn.");
				System.out.println();
				stay = true;
			} else {
				System.out.println("That's not a valid option.");
				System.out.println("Please choose \"Y\" for Hit or \"N\" for Stay");
				System.out.println();
			} // if curly brace
		} // stay curly brace
		return true;
	} // playersTurn method curly brace

	public boolean dealersTurn(Dealer dealer) {
		boolean stay = false;
		
		if (dealer.getPlayerHand().isBlackJack()) {
			System.out.print("Dealer's ");
			((Player) dealer).showHand();
			System.out.println();
			System.out.println("Blackjack. The Dealer wins. The round is over");
			System.out.println();
			return false;
		}
		
		while (!stay) {
			// The dealer turns over his hidden card. ...
			// ...and the hand and hand value are displayed.
			System.out.print("Dealer's ");
			((Player) dealer).showHand();
			System.out.println();
			
			
			if (dealer.getPlayerHand().is17OrOver()) {
				// If the hand value is 17 or over 17, the dealer must stay.
				System.out.println("Dealer has 17 or more. Dealer stays.");
				System.out.println();
				stay = true;
			} // 17 or over 17 cb
			else if (dealer.getPlayerHand().isBust()) {
//		If the dealer's hand is over 21, dealer busts.
				System.out.println("Dealer hand is over 21. Bust. Player wins! The round is over");
				System.out.println();
				return false;
			} else {
				// The dealer MUST Hit if the hand Value is below 17.
				System.out.println("Dealer has less than 17. Dealer must hit.");
				System.out.println();
				dealer.hit(dealer.getPlayerHand());
			} // under 17 cb

		} // stay curly brace

		return true;
	} // dealersTurn method curly brace

	public void evaluateHand(Player player, Dealer dealer) {
//	When the dealer stands, determine the winner of the round by comparing hand values. 
		System.out.print("Player's ");
		player.showHand();
		System.out.println();
		
		System.out.print("Dealer's ");
		((Player) dealer).showHand();
		System.out.println();

		if (player.getPlayerHand().getHandValue() > dealer.getPlayerHand().getHandValue()) {
//		 If the player hand value is greater than the dealer's the player wins. Otherwise, the dealer wins.
			System.out.println("Player wins! Round over.");
			System.out.println();
		} else if (player.getPlayerHand().getHandValue() == 21 && dealer.getPlayerHand().getHandValue() == 21) {
//			If they both have 21, it's a tie. Round is still over. 
			System.out.println("It's a tie! The round is over");
			System.out.println();
		} else {
			System.out.println("Dealer wins. Round over");
			System.out.println();
		}
	} // evaluateHand method cb

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
		System.out.println();

		String userInput = sc.nextLine();

		if (userInput.toUpperCase().startsWith("Y")) {

			if (dealer.getDeck().cardsLeftInDeck() < 12) {
				dealer.getNewDeck();
				System.out.println("Dealer shuffling new deck");
				System.out.println();
			}
		} else if (userInput.toUpperCase().startsWith("N")) {
			System.out.println("Thank you for playing BlackJack. Goodbye!");
			return false;
		} else {
			System.out.println("That's not a valid option.");
			System.out.println("Please choose \"Y\" for Yes or \"N\" for No");
			System.out.println();
		}
		return true;
	}

}
