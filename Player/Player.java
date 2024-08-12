package Player;

import java.util.List;
import Card.Card;
import Game.Game;
import Deck.Deck;


public abstract class Player {
    private List<Card> cards;
//    private String state = "Pending";
    private String name;

    protected Player(List<Card> cards) {
        this.cards = cards;
    };

//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public String getState() {
//        return state;
//    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards(){
        return cards;
    }

    public String getName() {
        return name;
    }

    public abstract void draw(Deck deck, Game game);

    public abstract void placeCard(List<Card> playGround, Game game);

}
