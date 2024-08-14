package Effects;

import Deck.Deck;
import Game.Game;
import Player.Player;

import java.util.*;

public class ChangeColorEffect implements Effect {

    private static volatile ChangeColorEffect instance;

    private ChangeColorEffect() {
        super();
    }

    public static ChangeColorEffect getInstance() {
        ChangeColorEffect result = instance;
        if (result == null) {
            synchronized (ChangeColorEffect.class) {
                instance = result = new ChangeColorEffect();
            }
        }
        return result;
    }

    @Override
    public void execute(Game game, Player currentPlayer, Player nextPlayer){
        Random random = new Random();
        int randomNumber = random.nextInt(game.getColors().length);
        String color = game.getColors()[randomNumber];
        game.setActiveColor(color);
        System.out.println("The active color was changed to: " + color);
    }
}
