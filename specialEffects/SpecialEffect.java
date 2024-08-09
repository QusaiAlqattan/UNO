package specialEffects;

import Game.Game;
import Player.Player;

public interface SpecialEffect {
    void execute(Game game, Player currentPlayer, Player nextPlayer);
}
