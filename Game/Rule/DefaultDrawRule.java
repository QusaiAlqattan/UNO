package Game.Rule;

import java.util.List;
import Card.Card;
import Player.Player;
import Game.Game;
import java.util.Random;

public abstract class DefaultDrawRule{

    public static void runRule(Player player, Game game){
        List<Card> deck = game.getDeck();
        Random random = new Random();
        int index = random.nextInt(deck.size()); // Generate a random index
        Card drawnCard = deck.get(index); // Get the card at that index
        deck.remove(index); // Remove the card from the deck
        player.addCard(drawnCard); // Add the card to the player's cards
    }
}
