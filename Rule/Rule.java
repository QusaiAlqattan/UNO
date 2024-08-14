package Rule;

import Card.*;
//import Card.SpecialCard;
//import Card.NormalCard;
import Player.*;
//import Player.DefaultPlayer;
import Game.Game;
//import java.util.List;
//import java.util.Random;
import java.util.*;
import Deck.Deck;
import Effects.*;
//import Rule.RuleToolBox.RuleToolBox;
import Rule.RuleToolBox.*;


public abstract class Rule {

    public boolean placeCardRule(Player player, Game game){
        List<Card> playerHand = player.getCards();
        List<Card> playGround = game.getPlayGround();

        Card lastPlacedUnoCard = playGround.getLast();;

        for (Card card : playerHand) {
            // TODO: fix this condition
            if (card instanceof SpecialCard && ((SpecialCard) card).isWild()
            || card.getColor().equals(game.getActiveColor())
            || card instanceof NormalCard && ((NormalCard) card).getNumber().equals(((NormalCard)lastPlacedUnoCard).getNumber())){
                playerHand.remove(card);
                playGround.add(card);

                return true;
            }
        }
        return false;
    }

    public boolean drawRule(Player player, Game game){
        Deck deck = game.getDeck();
        if (deck.listCards().isEmpty()){
            return false;
        }
        List<Card> deckCards = deck.listCards();
        Random random = new Random();
        int index = random.nextInt(deckCards.size()); // Generate a random index
        Card drawnCard = deckCards.get(index); // Get the card at that index
        deckCards.remove(index); // Remove the card from the deck
        player.addCard(drawnCard); // Add the card to the player's cards
        return true;
    }

    public List<Card> createDeckRule(){
        List<Card> deckCards = new ArrayList<>();
        String[] colors = {"Red", "Yellow", "Green", "Blue"};
        String[] numbers = {"1", "2", "3", "4","5","6","7","8","9"};

        // create wild cards
        // create ChangeColor cards
        for (int i = 0; i < 4; i++)
            deckCards.add(new SpecialCard("Black", DrawFourEffect.getInstance(), true, "ChangeColor"));

        // create Draw4 cards
        for (int i = 0; i < 4; i++)
            deckCards.add(new SpecialCard("Black", ChangeColorEffect.getInstance(), true, "Draw4"));


        // create colored cards
        for (String color : colors) {
            // create "0" card
            deckCards.add(new NormalCard(color, "0"));

            // create numbered cards
            int count = 1;
            for (String number : numbers) {
                for (int i = 0; i < 2; i++)
                    deckCards.add(new NormalCard(color, String.valueOf(count)));
                count++;
            }

            // create colored special effect cards
            for (int i = 0; i < 2; i++){
                deckCards.add(new SpecialCard(color, SkipEffect.getInstance(), false, "SkipCard"));
                deckCards.add(new SpecialCard(color, ReverseEffect.getInstance(), false, "ReverseCard"));
                deckCards.add(new SpecialCard(color, DrawTwoEffect.getInstance(), false, "Draw2"));
            }
        }
        return deckCards;
    }

    public boolean createPlayersRule(Game game, int noOfPlayers) {
        Deck deck = game.getDeck();
        if (noOfPlayers > 1) {
            for (int i = 0; i < noOfPlayers; i++) {
                List<Card> playerHand = new ArrayList<>(); // Initialize the list
                for (int j = 0; j < 7; j++) {
                    Card wantedCard = RuleToolBox.getRandomCardFromDeck(deck);
                    playerHand.add(wantedCard);
                    deck.removeCard(wantedCard);
                }
                game.addPlayer(new DefaultPlayer(playerHand));
            }
            return true;
        }
        return false;
    }

}
