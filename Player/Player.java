package Player;

import java.util.List;
import Card.Card;
import Game.Game;


public abstract class Player {
    private List<Card> cards;
    private String state = "Pending";

    protected Player(List<Card> cards) {
        this.cards = cards;
    };

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards(){
        return cards;
    }

    public abstract void draw(List<Card> deck, Game game);

    public abstract boolean placeCard(List<Card> playGround, Game game);

}
