package specialEffects;

import Game.Game;
import Player.Player;

public class SkipEffect implements SpecialEffect {
    @Override
    public void execute(Game game, Player currentPlayer, Player nextPlayer){
        game.skip();
    }
}