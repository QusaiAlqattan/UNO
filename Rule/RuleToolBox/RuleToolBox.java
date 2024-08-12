package Rule.RuleToolBox;

import Card.Card;
import Deck.Deck;

import java.util.List;
import java.util.Random;

public abstract class RuleToolBox {
    public static Card getRandomCardFromDeck(Deck deck){
        List<Card> deckCards = deck.listCards();
        Random random = new Random();
        int index = random.nextInt(deckCards.size());
        return deckCards.get(index);
    }
}
