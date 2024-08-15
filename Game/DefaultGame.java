package Game;

import Card.*;
import Deck.*;
import Game.GameToolBox.FlowCounter;
import Player.*;
import java.util.*;
import Rule.*;


public class DefaultGame extends Game {
    private static volatile DefaultGame instance;

    private DefaultGame() {
        super();
        String[] colors = {"Red", "Blue", "Yellow", "Green"};
        this.setColors(colors);
    }

    public static DefaultGame getInstance() {
        DefaultGame result = instance;
        if (result == null) {
            synchronized (DefaultGame.class) {
                instance = result = new DefaultGame();
            }
        }
        return result;
    }

    // initialization methods' template
    // 1: create a rule
    @Override
    public void setMyRule(){
        this.setRule(DefaultRule.getInstance());
    }

    // 2: create deck
    @Override
    public void setMyDeck(){
        this.setDeck(DefaultDeck.getInstance(this));
        this.getDeck().setCards(this.getRule().createDeckRule());
    }

    // 3: create players and give cards to them
    @Override
    public boolean createPlayers(Game game, int noOfPlayers){
        return game.getRule().createPlayersRule(game, noOfPlayers);
    }

    // 4: add first card to playground
    // use original

    // 5: game flow
    // use original
}
