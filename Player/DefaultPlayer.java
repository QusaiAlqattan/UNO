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
    public void draw(Deck deck, Game game) {
        game.getRule().drawRule(this, game);
    }

    @Override
    public void placeCard(List<Card> playGround, Game game) {
        game.getRule().placeCardRule(this, game);
    }
}
