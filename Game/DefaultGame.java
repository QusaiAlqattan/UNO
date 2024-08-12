package Game;

import Card.Card;
import Deck.Deck;
import Player.Player;
import java.util.List;
import Rule.Rule;


public class DefaultGame extends Game {

    private static volatile DefaultGame instance;

    private DefaultGame(List<Player> Players, Rule rule, Deck deck) {
        super(Players, rule, deck);
    }

    public static DefaultGame getInstance(List<Player> Players, Rule rule, Deck deck) {
        DefaultGame result = instance;
        if (result == null) {
            synchronized (DefaultGame.class) {
                instance = result = new DefaultGame(Players, rule, deck);
            }
        }
        return result;
    }

    // TODO: question if i override functions in side a function implemented in the parent ,like createPlayers in iniatilzeGame, will the new function run or the old one?
    // initialization methods' template
    // 1: create deck

    // 2: create players and give cards to them
    @Override
    protected void createPlayers(Game game, int noOfPlayers){
        game.getRule().createPlayersRule(game, noOfPlayers);
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
