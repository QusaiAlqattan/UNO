package Game.Rule;

import java.util.List;
import Card.Card;
import Player.Player;
import Game.Game;
import java.util.Objects;

public abstract class DefaultPlaceCardRule {

    public static boolean runRule(Player player, Game game){
        List<Card> cards = player.getCards();
        List<Card> playGround = game.getPlayGround();
        Card lastPlacedCard = playGround.get(cards.size() - 1);
        for (Card card : cards) {
            if (card.isWild() || Objects.equals(card.getColor(), lastPlacedCard.getColor()) || Objects.equals(card.getValue(), lastPlacedCard.getValue())) {
                cards.remove(card);
                playGround.add(card);
                return true;
            }
        }
        return false;
    }
}
