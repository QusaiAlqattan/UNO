package Rule;

import Deck.Deck;
import Deck.DefaultDeck;
import Game.Game;
import Player.Player;

import java.util.List;

public class DefaultRule extends Rule {
    private static volatile DefaultRule instance;

    private DefaultRule() {super();}

    public static DefaultRule getInstance() {
        DefaultRule result = instance;
        if (result == null) {
            synchronized (DefaultRule.class) {
                instance = result = new DefaultRule();
            }
        }
        return result;
    }
}
