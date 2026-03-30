package activity;

import java.util.ArrayList;

/**
 * An implementation of {@link CardGame} that simulates a simplified game of Blackjack.
 * {@code blackjack_rules.txt} should be consulted to see the rules of the game that are
 * adhered to in the implementation of this class.
 * @implNote This game does not include any betting. CSE116 does not endorse gambling!
 */
public class Blackjack extends CardGame {

    private final ArrayList<Card> playerHand;
    private final ArrayList<Card> dealerHand;

    /**
     * A constructor that initializes the player and dealer's hands, and shuffles the deck.
     */
    public Blackjack() {
        this.playerHand = new ArrayList<>();
        this.dealerHand = new ArrayList<>();
        this.deck.shuffle();
    }

    /**
     * An alternate constructor that initializes the player and dealer's hands,
     * but also allows you so supply any {@link Deck} to the game.
     * @implNote This method is not needed, but was added to make testing this activity easier!
     * @param deck the {@link Deck} to be used for the game.
     */
    public Blackjack(Deck deck) {
        super(deck);
        this.playerHand = new ArrayList<>();
        this.dealerHand = new ArrayList<>();
    }

    /**
     * Calculates the score value of a hand. Score is calculated according to the
     * values of each card as defined in the game rules.
     * @param hand the hand to find the value of
     * @return the total score of that hand
     */
    private int getHandValue(ArrayList<Card> hand) {
        int val = 0;
        int aces = 0;
        for (Card c : hand) {
            val += switch (c.rank()) {
                case Card.Rank.TWO -> 2;
                case Card.Rank.THREE -> 3;
                case Card.Rank.FOUR -> 4;
                case Card.Rank.FIVE -> 5;
                case Card.Rank.SIX -> 6;
                case Card.Rank.SEVEN -> 7;
                case Card.Rank.EIGHT -> 8;
                case Card.Rank.NINE -> 9;
                case Card.Rank.TEN, Card.Rank.QUEEN, Card.Rank.JACK, Card.Rank.KING -> 10;
                case Card.Rank.ACE -> 11;
            };
            if (c.rank().equals(Card.Rank.ACE)) aces++;
        }
        while (val > 21 && aces > 0) {
            aces--;
            val -= 10;
        }
        return val;
    }

    /**
     * Executes the functionality of the player's turn in Blackjack.
     */
    private void playerTurn() {
        System.out.println("Beginning player turn");
        while (getHandValue(this.playerHand) < 21 && getHandValue(this.dealerHand) < 21) {
            reportScores(getHandValue(this.playerHand),getHandValue(this.dealerHand));
            if (askPlayer("Draw another card?")) {
                this.playerHand.add(this.deck.drawCard());
            } else {
                return;
            }
        }
        System.out.println("Hand total is at least 21, ending player turn");
    }

    /**
     * Executes the functionality of the dealer's turn in Blackjack.
     */
    private void dealerTurn() {
        System.out.println("Beginning dealer turn");
        while (getHandValue(this.dealerHand) < 16) {
            this.dealerHand.add(this.deck.drawCard());
        }
    }

    /**
     * Checks the values of the player and dealer's hands to determine the winner of the round.
     * @return {@code true} if the player wins, {@code false} otherwise.
     */
    private boolean evaluateWin() {
        return (getHandValue(this.playerHand) >= getHandValue(this.dealerHand) || getHandValue(this.dealerHand) > 21)
                && getHandValue(this.playerHand) <= 21;
    }

    //Run this to play a round of Blackjack!
    public static void main(String[] args) {
        Blackjack game = new Blackjack();
        game.playGame();
    }
}
