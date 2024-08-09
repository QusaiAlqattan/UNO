package Effects;

import Game.Game;
import Player.Player;

public class DrawTwoEffect implements Effect {

    @Override
    public void execute(Game game, Player currentPlayer, Player nextPlayer){
        for (int i = 0; i < 2; i++)
            currentPlayer.draw(game.getDeck(), game);
    }
}
