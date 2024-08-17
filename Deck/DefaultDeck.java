package Deck;

import Game.Game;


public class DefaultDeck extends Deck{
    private static volatile DefaultDeck instance;


    private DefaultDeck(Game game) {
        this.setCards(game.getRule().createDeckRule(game));
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
