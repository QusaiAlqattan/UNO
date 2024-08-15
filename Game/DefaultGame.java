package Game;

import Card.*;
import Deck.*;
import Rule.*;

import java.util.*;


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
        this.setRule(new Rule());
    }

    // 2: create deck
    @Override
    public void setMyDeck(){
        this.setDeck(DefaultDeck.getInstance(this));
        this.getDeck().setCards(this.getRule().createDeckRule());
    }

    // 3: create players and give cards to them
    @Override
    public boolean createPlayers(Game game){
        return game.getRule().createPlayersRule(game);
    }

    // 4: add first card to playground
    @Override
    public void addToPlayGround(Game game){
        game.getRule().addToPlayGroundRule(game);
    }

    // 5: game flow
    @Override
    public void gameFlow(Game game){
        game.getRule().gameFlowRule(game);
    }
}
