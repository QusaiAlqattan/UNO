package Player;

import Card.Card;
import java.util.List;
import Game.Game;
import Rule.Rule;
import Deck.Deck;


public class DefaultPlayer extends Player {

    public DefaultPlayer(List<Card> cards) {
        super(cards);
    }

    @Override
    public boolean draw(Game game) {
        return game.getRule().drawRule(this, game);
    }

    @Override
    public boolean placeCard(Game game) {
        return game.getRule().placeCardRule(this, game);
    }
}
