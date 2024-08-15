package Effects;

import Game.Game;
import Player.Player;
import Deck.Deck;

public class DrawTwoEffect implements Effect {

    @Override
    public void execute(Game game, Player currentPlayer, Player nextPlayer, int nextPlayerIndex){
        for (int i = 0; i < 2; i++)
            nextPlayer.draw(game);

        System.out.println("bot"+nextPlayer.getId()+" has drawn 2 cards now he has "+nextPlayer.getCards().size()+" cards");
    }
}
