package Effects;

import Card.*;
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
    public void execute(Game game, Player currentPlayer, Player nextPlayer, int nextPlayerIndex){
        // draw4
        for (int i = 0; i < 4; i++)
            nextPlayer.draw(game);

        System.out.println("bot"+nextPlayerIndex+" has drawn 4 cards");

        // change color
        Card card = game.getPlayGround().getLast();
        if(card instanceof SpecialCard specialcard)
            specialcard.getSpecialEffect().execute(game, currentPlayer, nextPlayer, nextPlayerIndex);

    }
}
