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
    public void setMyRule(){
        this.setRule(new Rule());
    }

    // 2: create deck
    public void setMyDeck(){
        this.setDeck(DefaultDeck.getInstance(this));
        this.getDeck().setCards(this.getRule().createDeckRule());
    }

    // 3: create players and give cards to them
    public void createPlayers(Game game){
        game.getRule().createPlayersRule(game, 10, 2);
    }

    // 4: add first card to playground
    public void addToPlayGround(Game game){
        game.getRule().addToPlayGroundRule(game);
    }

    // 5: game flow
    public void gameFlow(Game game){
        game.getRule().gameFlowRule(game);
    }

    // initialization template method
    public final void play(){
        //1
        this.setMyRule();

        //2
        this.setMyDeck();

        //3
        createPlayers(this);

        //4
        addToPlayGround(this);

        //5
        gameFlow(this);
    }
}
