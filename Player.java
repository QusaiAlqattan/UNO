import java.util.List;
import java.util.Random;

public class Player {
    private List<Card> cards;

//    public List<Card> getCards(){
//        return cards;
//    }

    public boolean won() {
        return cards.isEmpty();
    }

    // Method to add a card to the list
    public void draw(List<Card> deck) {
        Random random = new Random();
        int index = random.nextInt(deck.size()); // Generate a random index
        Card drawnCard = deck.get(index); // Get the card at that index
        deck.remove(index); // Remove the card from the deck
        cards.add(drawnCard); // Add the card to the player's cards
    }

    public boolean placeCard(List<Card> playGround) {
        Card lastPlacedCard = playGround.get(cards.size() - 1);
        for (Card card : cards) {
            if (card.isWild || card.color == lastPlacedCard.color || card.number == lastPlacedCard.number || card.specialEffect.equals(lastPlacedCard.specialEffect)) {
                cards.remove(card);
                playGround.add(card);
                return true;
            }
        }
        return false;
    }

}
