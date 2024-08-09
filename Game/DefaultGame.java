package Game;

import Card.Card;
import Player.Player;
import java.util.List;
import Game.Rule.*;

public class DefaultGame extends Game {

    public DefaultGame(List<Card> deck, boolean clockWise, List<Player> Players) {
        super(deck, clockWise, Players);
    }

    public void play(){
        // TODO: implement this function
    };

    @Override
    public void createDeck(Game game) {
        DefaultCreateDeckRule.runRule(game);
    }

    ;
}
