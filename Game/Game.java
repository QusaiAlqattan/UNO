package Game;

import java.util.ArrayList;
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

    public abstract void play();

    public boolean isClockWise() {
        return clockWise;
    }

    public void reverse() {
        this.clockWise = !clockWise;
    }

    public abstract void createDeck(Game game);

    public List<Card> getDeck() {
        return deck;
    }

    public List<Card> getPlayGround() {
        return playGround;
    }

    public void addToPlayGround(Card card) {
        playGround.add(card);
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
}
