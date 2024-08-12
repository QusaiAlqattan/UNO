package Deck;

import Card.Card;
import java.util.*;


public abstract class Deck {
    private List<Card> cards;


    public List<Card> listCards(){
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void removeCard(Card card){
        cards.remove(card);
    }
}
