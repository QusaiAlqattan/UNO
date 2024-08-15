package Rule.RuleToolBox;

import Card.Card;
import Deck.Deck;
import Game.Game;
import Player.Player;

import java.util.*;


public abstract class RuleToolBox {
    public static Card getRandomCardFromDeck(Deck deck){
        List<Card> deckCards = deck.listCards();
        Random random = new Random();
        int index = random.nextInt(deckCards.size());
        return deckCards.get(index);
    }

    public static int getNoOfPlayers(int max, int min){
        if (min < 2 || min > max){
            throw new IllegalArgumentException("min must be between 2 and max");
        }

        // get input for user
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;

        while (true) {
            System.out.println("Please enter the number of players between " + min + " and " + max + ":");

            try {
                // Read user input
                userInput = scanner.nextInt();

                // Check if the input is within the range
                if (userInput >= min && userInput <= max) {
                    break;
                } else {
                    System.out.println("The number is out of range. Please try again.");
                }
            } catch (InputMismatchException e) {
                // Handle invalid input (non-integer values)
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }
        scanner.close();

        return userInput;
    }

    public static int moveFlow(Game game, int i, int j) {
        if (game.isClockWise()) {
            i = (i + 1) % j;  // Move to the next index and wrap around using modulus
        } else {
            i = (i - 1 + j) % j;  // Move to the previous index and wrap around using modulus
        }

        return i;
    }

    public static void Scorer(Game game, List<Player> finishedPlayers){
        game.getRule().scoringRule(finishedPlayers);
    }
}
