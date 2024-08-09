package Player;

import Card.Card;
import java.util.List;
import Game.Game;
import Rule.Rule;


public class DefaultPlayer extends Player {

    public DefaultPlayer(List<Card> cards) {
        super(cards);
    }

    @Override
    public void draw(List<Card> deck, Game game) {
        Rule.drawRule(this, game);
    }

    @Override
    public boolean placeCard(List<Card> playGround, Game game) {
        return Rule.placeCardRule(this, game);
    }
}
