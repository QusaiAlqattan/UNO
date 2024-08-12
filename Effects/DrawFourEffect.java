package Effects;

import Deck.Deck;
import Game.Game;
import Player.Player;

import java.util.List;

public class DrawFourEffect implements Effect {

    private static volatile DrawFourEffect instance;

    private DrawFourEffect() {
        super();
    }

    public static DrawFourEffect getInstance() {
        DrawFourEffect result = instance;
        if (result == null) {
            synchronized (DrawFourEffect.class) {
                instance = result = new DrawFourEffect();
            }
        }
        return result;
    }

    @Override
    public void execute(Game game, Player currentPlayer, Player nextPlayer){
        for (int i = 0; i < 4; i++)
            currentPlayer.draw(game.getDeck(), game);
    }
}
