package Player;

import Card.Card;
import java.util.List;
import Game.Rule.*;
import Game.Game;

public class DefaultPlayer extends Player {

    @Override
    public void draw(List<Card> deck, Game game) {
        DefaultDrawRule.runRule(this, game);
    }

    @Override
    public boolean placeCard(List<Card> playGround, Game game) {
        return DefaultPlaceCardRule.runRule(this, game);
    }
}
