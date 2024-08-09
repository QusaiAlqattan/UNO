package Game;

import java.util.List;
import Card.Card;
import Player.Player;


public abstract class Game {
    private List<Card> deck;
    private List<Card> playGround;
    private boolean clockWise;
    private List<Player> activePlayers;

    protected Game(List<Card> deck, boolean clockWise, List<Player> Players) {
        this.deck = deck;
        this.clockWise = clockWise;
        this.activePlayers = Players;
    }

    public boolean isClockWise() {
        return clockWise;
    }

    public void reverse() {
        this.clockWise = !clockWise;
    }

    public List<Card> getDeck() {
        return deck;
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

    public String skip(){
        // TODO: implement this function
        return "Skip";
    }

    // initialization methods' template
    // 1: create deck
    public abstract void createDeck(Game game);

    // 2: create players and give cards to players
    protected abstract void createPlayers(Game game, int noOfPlayers);

    // 3: add first card to playground
    public abstract void addToPlayGround(Card Card);

    // initialization template method
    public void iniatilzeGame(Game game, int noOfPlayers, Card Card) {
        createDeck(game);
        createPlayers(game, noOfPlayers);
        addToPlayGround(Card);
    }

    public void play(Game game, int noOfPlayers, Card Card){
        iniatilzeGame(game, noOfPlayers, Card);
    }
}
