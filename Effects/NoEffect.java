package Effects;

import Game.Game;
import Player.Player;

public class NoEffect implements Effect {

    @Override
    public void execute(Game game, Player currentPlayer, Player nextPlayer){}
}
