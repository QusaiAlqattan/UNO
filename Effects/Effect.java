package Effects;

import Deck.Deck;
import Game.Game;
import Player.Player;

public interface Effect {
    void execute(Game game, Player currentPlayer, Player nextPlayer, int nextPlayerIndex);
}
