package Game;

import java.util.List;
import Card.Card;
import Deck.Deck;
import Player.Player;
import Rule.Rule;


public abstract class Game {
    private List<Card> playGround;
    private boolean clockWise = true;
    private List<Player> activePlayers;
    private Rule rule;
    private Deck deck;

    protected Game(List<Player> Players, Rule rule, Deck deck) {
        this.activePlayers = Players;
        this.rule = rule;
        this.deck = deck;
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

    public int getActivePlayersNumber() {
        return activePlayers.size();
    }

    public Rule getRule() {
        return rule;
    }

    public Deck getDeck() {
        return deck;
    }

    public String skip(){
        // TODO: implement this function
        return "Skip";
    }

    // initialization methods' template
    // 1: create deck

    // 2: create players and give cards to players
    protected abstract void createPlayers(Game game, int noOfPlayers);

    // 3: add first card to playground
    public abstract void addToPlayGround(Card Card);

    // initialization template method
    public void iniatilzeGame(Game game, int noOfPlayers, Card Card) {
        createPlayers(game, noOfPlayers);
        addToPlayGround(Card);
    }

    public void play(Game game, int noOfPlayers, Card Card){
        iniatilzeGame(game, noOfPlayers, Card);
    }
}
