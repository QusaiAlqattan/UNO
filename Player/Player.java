package Player;

import java.util.List;
import Card.Card;
import Game.Game;
import Deck.Deck;


public abstract class Player {
    private List<Card> cards;
//    private String state = "Pending";
    private int id;

    protected Player(List<Card> cards, int id) {
        this.cards = cards;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public abstract boolean draw(Game game);

    public abstract boolean placeCard(Game game);

}
