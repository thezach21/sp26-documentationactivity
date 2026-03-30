# Documentation Lab Activity

This activity is intended to give you some practice working with code
you are unfamiliar with by reading that code's documentation. To accomplish
this, you will be making a terminal-based game of Blackjack using preexisting
tools for making card games.

The code you need to write to get the game working should be simple, as most
of the work is done for you, but it would be tricky to figure out how the given
code works and how you need to use it. Thankfully, all the given code as well as
the rules for what you have to write are clearly documented and laid out for you,
so by reading through everything you should be able to get it working despite
not fully understanding the code. That is the main purpose of this activity —
demonstrating that if code is well documented, you don't actually need to know
how it works to use it!

Your task is to implement the three abstract methods the Blackjack class
inherits from the CardGame class. The Blackjack class already has several helper
methods that will be of great use to you as you make the functionality of the
game. You should look carefully at each existing class and method to find out
which you will need to use and how you will need to use them.

Reading `blackjack_rules.txt` should help you understand what steps
need to be taken to make the game work as it should. If your `playGame` method
performs the steps in "GAME START & PLAYER TURN" followed by "DEALER TURN",
then decides the winner according to "WINNING & LOSING", your game should
work as intended.

You can test your game by running the main method of the Blackjack class. When
you get it working, submit to Autolab to get credit (See grading notes below!).
Once you have the game working correctly, you should write some Javadoc comments
of your own on your methods!

### GRADING NOTES
Due to the fact that testing a terminal-based game with random elements is rather difficult, the
following stipulations must be followed for grading to happen properly:
- DO NOT call the `shuffle()` method outside the Blackjack constructor. This will make test cases
  random and not work properly!
- ALWAYS call either the `win()` method or the `lose()` method when you reach a game over state. These
  methods are used to determine the result of test cases! Do not worry about how you implement them,
  the grader should work regardless.
- Ensure that when beginning a game, two cards are dealt to the player, then one to the dealer, then
  the player turn begins. This will ensure that deck ordering in test cases is as expected.
- Ensure that the playGame method only plays a single round of the game, and does not have a way to
  play again without the method being called a second time. If you would like to be able to play
  multiple rounds without rerunning the game you are encouraged to set that up in the main method
  of the Blackjack class rather than in playGame.