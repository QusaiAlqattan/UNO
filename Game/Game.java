// done TODO: fix game singleton
// done TODO: if game singleton is fixed, reflect it on effects
// notDone TODO: ?deck constructor uses the create default deck rule
// done TODO: fix game creation template
// notDone TODO: ask, can i force subclasses to be singletons
// done TODO: implement the play() method
// done TODO: implement game.skip()
// done TODO: implement game.reverse()
// done TODO: implement changeColorEffect
// done TODO: fix singleton in effects
// done TODO: print
// done TODO: demo
// notDone TODO: fix placeCard rule
// TODO: exception handling
// done TODO: remove singleton from effect
// notDone TODO: make smart bots
// done TODO: make user enter the number of players
// done TODO: remove singleton from rule

package Game;

import java.util.*;

import Card.*;
import Deck.*;
import Player.*;
import Rule.*;


public abstract class Game {
    private List<Card> playGround = new ArrayList<>();
    private boolean clockWise = true;
    private List<Player> activePlayers = new ArrayList<Player>();
    private Rule rule;
    private Deck deck;
    private boolean isSkip;
    private String activeColor;
    private String[] colors;

    protected Game() {}

    public String[] getColors() {
        return colors;
    }
    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public void setActiveColor(String activeColor) {
        this.activeColor = activeColor;
    }
    public String getActiveColor() {
        return activeColor;
    }

    public boolean isClockWise() {
        return clockWise;
    }
    public void reverse() {
        this.clockWise = !clockWise;
    }

    public List<Card> getPlayGround() {
        return playGround;
    }

    public void addPlayer(Player player) {
        this.activePlayers.add(player);
    }
    public void removePlayer(Player player) {
        this.activePlayers.remove(player);
    }
    public List<Player> getActivePlayers() {
        return activePlayers;
    }

    public void setRule(Rule rule){
        this.rule = rule;
    }
    public Rule getRule() {
        return rule;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
    public Deck getDeck() {
        return deck;
    }

    public boolean isSkip(){
        return isSkip;
    }
    public void setSkip(boolean skip){
        this.isSkip = skip;
    }

    // initialization methods' template
    // 1: create a rule
    public abstract void setMyRule();

    // 2: create a deck
    public abstract void setMyDeck();

    // 3: create players and give cards to players
    protected abstract boolean createPlayers(Game game);

    // 4: add first card to playground
    public abstract void addToPlayGround(Game game);

    // 5: game flow
    public abstract void gameFlow(Game game);

    // initialization template method
    public final void play(){
        //1
        this.setMyRule();

        //2
        this.setMyDeck();

        //3
        if (!(createPlayers(this))){
            // TODO: raise exception
        }else{
            //4
            addToPlayGround(this);

            //5
            gameFlow(this);
        }
    }
}
