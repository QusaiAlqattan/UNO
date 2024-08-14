package Effects;

import Game.Game;
import Player.Player;
import Deck.Deck;

public class DrawTwoEffect implements Effect {

    private static volatile DrawTwoEffect instance;

    private DrawTwoEffect() {
        super();
    }

    public static DrawTwoEffect getInstance() {
        DrawTwoEffect result = instance;
        if (result == null) {
            synchronized (DrawTwoEffect.class) {
                instance = result = new DrawTwoEffect();
            }
        }
        return result;
    }

    @Override
    public void execute(Game game, Player currentPlayer, Player nextPlayer, int nextPlayerIndex){
        for (int i = 0; i < 2; i++)
            nextPlayer.draw(game);

        System.out.println("bot"+nextPlayerIndex+" has drawn 2 cards");
    }
}
