package Game;

import Card.Card;
import Player.Player;
import java.util.ArrayList;
import java.util.List;
import Rule.Rule;


public class DefaultGame extends Game {

    private static volatile DefaultGame instance;

    private DefaultGame(List<Card> deck, boolean clockWise, List<Player> Players) {
        super(deck, clockWise, Players);
    }

    public static DefaultGame getInstance(List<Card> deck, boolean clockWise, List<Player> Players) {
        DefaultGame result = instance;
        if (result == null) {
            synchronized (DefaultGame.class) {
                instance = result = new DefaultGame(deck, clockWise, Players);
            }
        }
        return result;
    }

    // initialization methods' template
    // 1: create deck
    @Override
    public void createDeck(Game game) {
        Rule.createDeckRule(game);
    }

    // 2: create players and give cards to them
    @Override
    protected void createPlayers(Game game, int noOfPlayers){
        Rule.createPlayerRule(game, noOfPlayers);
    }

    // 3: add first card to playground
    @Override
    public void addToPlayGround(Card unoCard){
        this.getPlayGround().add(unoCard);
    }

    @Override
    public void play(Game game, int noOfPlayers, Card Card){
        super.play(game, noOfPlayers, Card);
        // TODO: continue the flow
    }
}
