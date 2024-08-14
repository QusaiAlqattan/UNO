// done TODO: fix game singleton
// done TODO: if game singleton is fixed, reflect it on effects
// notDone TODO: ?deck constructor uses the create default deck rule
// done TODO: fix game creation template
// wait TODO: ask, can i force subclasses to be singletons
// done TODO: implement the play() method
// done TODO: implement game.skip()
// TODO: implement game.reverse()
// done TODO: implement changeColorEffect
// wait TODO: fix singleton in effects
// done TODO: print
// TODO: demo
// wait TODO: fix placeCard rule
// TODO: exception handling

package Game;

import java.util.List;
import Card.*;
import Deck.*;
import Player.*;
import Rule.*;


public abstract class Game {
    private List<Card> playGround;
    private boolean clockWise = true;
    private List<Player> activePlayers;
    private Rule rule;
    private Deck deck;
    private boolean isSkip;
    private String activeColor;
    private String[] colors;

    protected Game(List<Player> Players) {
        this.activePlayers = Players;
    }

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

    public final void setRule(Rule rule){
        this.rule = rule;
    }
    public Rule getRule() {
        return rule;
    }

    public final void setDeck(Deck deck) {
        this.deck = deck;
    }
    public Deck getDeck() {
        return deck;
    }

    public boolean isSkip(){
        return isSkip;
    }
    public void skip(){
        // TODO: implement this function
        this.isSkip = true;
    }

    // initialization methods' template
    // 1: create a rule
    public abstract void setMyRule();

    // 2: create a deck
    public abstract void setMyDeck();

    // 3: create players and give cards to players
    protected abstract boolean createPlayers(Game game, int noOfPlayers);

    // 4: add first card to playground
    public abstract void addToPlayGround(Game game);

    // 5: start game
    public abstract void play();

    // initialization template method
    public final void createGame(int noOfPlayers) {
        // 1
        this.setMyRule();

        //2
        this.setMyDeck();

        //3
        if (!(createPlayers(this, noOfPlayers))){
            // TODO: raise exception
        }else{
            //4
            addToPlayGround(this);

            //5
            play();
        }
    }
}
