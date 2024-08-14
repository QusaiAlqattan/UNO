package Effects;

import Deck.Deck;
import Game.Game;
import Player.Player;

public class SkipEffect implements Effect {

    private static volatile SkipEffect instance;

    private SkipEffect() {
        super();
    }

    public static SkipEffect getInstance() {
        SkipEffect result = instance;
        if (result == null) {
            synchronized (SkipEffect.class) {
                instance = result = new SkipEffect();
            }
        }
        return result;
    }

    @Override
    public void execute(Game game, Player currentPlayer, Player nextPlayer, int nextPlayerIndex){
        game.skip();
    }
}