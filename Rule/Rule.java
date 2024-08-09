package Rule;

import Card.UnoCard;
import Card.Card;
import Player.Player;
import Player.DefaultPlayer;
import Game.Game;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.*;


public abstract class Rule {

    public static boolean placeCardRule(Player player, Game game){
        List<Card> cards = player.getCards();
        List<Card> playGround = game.getPlayGround();
        Card lastPlacedUnoCard = playGround.get(cards.size() - 1);
        for (Card card : cards) {
            if (card.isWild() || Objects.equals(card.getColor(), lastPlacedUnoCard.getColor()) || Objects.equals(card.getValue(), lastPlacedUnoCard.getValue())) {
                cards.remove(card);
                playGround.add(card);
                return true;
            }
        }
        return false;
    }

    public static void drawRule(Player player, Game game){
        List<Card> deck = game.getDeck();
        Random random = new Random();
        int index = random.nextInt(deck.size()); // Generate a random index
        Card drawnCard = deck.get(index); // Get the card at that index
        deck.remove(index); // Remove the card from the deck
        player.addCard(drawnCard); // Add the card to the player's cards
    }

    public static void createDeckRule(Game game){
        //TODO: implement this function (build a normal uno deck)
    }

    public static boolean createPlayerRule(Game game, int noOfPlayers) {
        if (noOfPlayers > 1) {
            for (int i = 0; i < noOfPlayers; i++) {
                List<Card> playerHand = new ArrayList<>(); // Initialize the list
                for (int j = 0; j < 7; j++) {
                    playerHand.add(getRandomCardFromDeck(game.getDeck()));
                }
                game.addPlayer(new DefaultPlayer(playerHand));
            }
            return true;
        } else {
            // Throw an exception if the number of players is insufficient
            throw new IllegalArgumentException("Number of players must be greater than 1");
        }
    }


    private static Card getRandomCardFromDeck(List<Card> deck){
        Random random = new Random();
        int index = random.nextInt(deck.size());
        return deck.get(index);
    }
}
