package Game;

import Card.*;
import Deck.*;
import Game.GameToolBox.FlowCounter;
import Player.*;
import java.util.*;
import Rule.*;


public class DefaultGame extends Game {
    private static volatile DefaultGame instance;

    private DefaultGame() {
        super();
        String[] colors = {"Red", "Blue", "Yellow", "Green"};
        this.setColors(colors);
    }

    public static DefaultGame getInstance() {
        DefaultGame result = instance;
        if (result == null) {
            synchronized (DefaultGame.class) {
                instance = result = new DefaultGame();
            }
        }
        return result;
    }

    // TODO: question if i override functions inside a function implemented in the parent ,like createPlayers in iniatilzeGame, will the new function run or the old one?
    // initialization methods' template
    // 1: create a rule
    @Override
    public void setMyRule(){
        this.setRule(DefaultRule.getInstance());
    }

    // 2: create deck
    @Override
    public void setMyDeck(){
        System.out.println("hi");
        this.setDeck(DefaultDeck.getInstance(this));
        this.getDeck().setCards(this.getRule().createDeckRule());
    }

    // 3: create players and give cards to them
    @Override
    public boolean createPlayers(Game game, int noOfPlayers){
        return game.getRule().createPlayersRule(game, noOfPlayers);
    }

    // 4: add first card to playground
    @Override
    public void addToPlayGround(Game game){
        // get a random card from deck
        Deck deck = game.getDeck();
        List<Card> deckCards = deck.listCards();
        Random random = new Random();
        int index = random.nextInt(deckCards.size()); // Generate a random index
        Card drawnCard = deckCards.get(index); // Get the card at that index

        // place the random card
        this.getPlayGround().add(drawnCard);
    }

    // 5: start game
    @Override
    public void gameFlow(){
        List<Player> players = this.getActivePlayers();

        int i = 0;
        while(players.size() > 2){
            Player activePlayer = players.get(i);

            // set counter value
            i = FlowCounter.moveFlow(this, i, players.size());

            if(!(activePlayer.placeCard(this))){
                // the player hasn't placed a card
                if(!(activePlayer.draw(this))){
                    // the player wasn't able to draw a card
                    System.out.println("The Game has ended because the deck is empty");
                    break;
                }

                // the player draw a card
            }else{
                // the player has placed a card
                Card placedCard = this.getPlayGround().getLast();
                System.out.println("bot"+i+" has placed a"+placedCard);

                // check if player has won
                if (activePlayer.getCards().isEmpty()){
                    System.out.println("bot"+i+" has no cards left");
                    this.removePlayer(activePlayer);
                }

                // run the card's effect
                if (placedCard instanceof SpecialCard specialCard){
                    specialCard.getSpecialEffect().execute(this, activePlayer, players.get(i), i);
                    if (this.isSkip()){
                        // placed card was a skip card
                        i = FlowCounter.moveFlow(this, i, players.size());
                        System.out.println("bot"+i+" was skipped");
                    }
                }
            }
        }
    }

}
