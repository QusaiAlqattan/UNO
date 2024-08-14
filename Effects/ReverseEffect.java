package Effects;

import Deck.Deck;
import Game.Game;
import Player.Player;

public class ReverseEffect implements Effect {

    private static volatile ReverseEffect instance;

    private ReverseEffect() {
        super();
    }

    public static ReverseEffect getInstance() {
        ReverseEffect result = instance;
        if (result == null) {
            synchronized (ReverseEffect.class) {
                instance = result = new ReverseEffect();
            }
        }
        return result;
    }

    @Override
    public void execute(Game game, Player currentPlayer, Player nextPlayer, int nextPlayerIndex){
        game.reverse();
    }
}
