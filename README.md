# BlackjackProject

## Description

This program is a Blackjack program that follows the rules of Blackjack, except that Aces are always 11.

When play begins, the dealer begins with a new, shuffled deck, and alternates dealing two cards to the player and two to
himself.

The user is given options to hit or stay, and the dealer follows blackjack rules on his turn.

If either player gets over 21, the game is immediately over.

At the end of each round, the user is given an option for a new game.

If the deck has less than 12 cards, the dealer will shuffle a new deck.

The program continues until the user chooses to stop playing.


## What I Learned

The biggest challenge in this program was figuring out what entities needed what fields and what behaviors and
how the entities worked together.

The logic was also a certain challenge, and I learned to use methods that returned booleans to evaluate loop
conditions.

I also learned how to use returns to exit methods before all the method code was run.

I learned that placing certain conditions before others is important, especially in the dealer's turn, where the condition
for bust needs to be placed before the condition for over 17 in order for the hands to evaluate properly.

I also learned how to use a do while loop to only loop in the play again method if the user did not give a valid option.



## Technologies Used
Java, Eclipse, Git, GitHub, MacOS Monterey