package Effects;

import Deck.Deck;
import Game.Game;
import Player.Player;

public class SkipEffect implements Effect {

    @Override
    public void execute(Game game, Player currentPlayer, Player nextPlayer, int nextPlayerIndex){
        game.setSkip(true);
    }
}