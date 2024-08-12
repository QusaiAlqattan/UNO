package Effects;

import Deck.Deck;
import Game.Game;
import Player.Player;

import java.util.List;

public class ChangeColorEffect implements Effect {

    private static volatile ChangeColorEffect instance;

    private ChangeColorEffect() {
        super();
    }

    public static ChangeColorEffect getInstance() {
        ChangeColorEffect result = instance;
        if (result == null) {
            synchronized (ChangeColorEffect.class) {
                instance = result = new ChangeColorEffect();
            }
        }
        return result;
    }

    @Override
    public void execute(Game game, Player currentPlayer, Player nextPlayer){
        // TODO: implement this function
    }
}
