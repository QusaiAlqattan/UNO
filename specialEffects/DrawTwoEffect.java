package specialEffects;

import Game.Game;
import Player.Player;

public class DrawTwoEffect implements SpecialEffect {

    @Override
    public void execute(Game game, Player currentPlayer, Player nextPlayer){
        for (int i = 0; i < 2; i++)
            nextPlayer.draw(game.getDeck(), game);
    }
}
