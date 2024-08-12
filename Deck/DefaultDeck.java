package Deck;

import Card.Card;
import Game.Game;
import Player.Player;
import java.util.List;
import Rule.Rule;


public class DefaultDeck extends Deck{
    private static volatile DefaultDeck instance;


    private DefaultDeck(Game game) {
        this.setCards(game.getRule().createDeckRule());
    }

    public static DefaultDeck getInstance(Game game) {
        DefaultDeck result = instance;
        if (result == null) {
            synchronized (DefaultDeck.class) {
                instance = result = new DefaultDeck(game);
            }
        }
        return result;
    }
}
