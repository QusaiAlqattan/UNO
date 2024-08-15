// done TODO: fix game singleton
// done TODO: if game singleton is fixed, reflect it on effects
// notDone TODO: ?deck constructor uses the create default deck rule
// done TODO: fix game creation template
// wait TODO: ask, can i force subclasses to be singletons
// done TODO: implement the play() method
// done TODO: implement game.skip()
// done TODO: implement game.reverse()
// done TODO: implement changeColorEffect
// wait TODO: fix singleton in effects
// done TODO: print
// TODO: demo
// wait TODO: fix placeCard rule
// TODO: exception handling
// done TODO: remove singleton from effect
// TODO: make smart bots
// TODO: make user enter the number of players

package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Card.*;
import Deck.*;
import Game.GameToolBox.FlowCounter;
import Player.*;
import Rule.*;


public abstract class Game {
    private List<Card> playGround = new ArrayList<>();
    private boolean clockWise = true;
    private List<Player> activePlayers = new ArrayList<Player>();
    private Rule rule;
    private Deck deck;
    private boolean isSkip;
    private String activeColor;
    private String[] colors;

    protected Game() {}

    public String[] getColors() {
        return colors;
    }
    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public void setActiveColor(String activeColor) {
        this.activeColor = activeColor;
    }
    public String getActiveColor() {
        return activeColor;
    }

    public boolean isClockWise() {
        return clockWise;
    }
    public void reverse() {
        this.clockWise = !clockWise;
    }

    public List<Card> getPlayGround() {
        return playGround;
    }

    public void addPlayer(Player player) {
        this.activePlayers.add(player);
    }
    public void removePlayer(Player player) {
        this.activePlayers.remove(player);
    }
    public List<Player> getActivePlayers() {
        return activePlayers;
    }

    public final void setRule(Rule rule){
        this.rule = rule;
    }
    public Rule getRule() {
        return rule;
    }

    public final void setDeck(Deck deck) {
        this.deck = deck;
    }
    public Deck getDeck() {
        return deck;
    }

    public boolean isSkip(){
        return isSkip;
    }
    public void setSkip(boolean skip){
        this.isSkip = skip;
    }

    // initialization methods' template
    // 1: create a rule
    public abstract void setMyRule();

    // 2: create a deck
    public abstract void setMyDeck();

    // 3: create players and give cards to players
    protected abstract boolean createPlayers(Game game, int noOfPlayers);

    // 4: add first card to playground
    public void addToPlayGround(){
        // get a random card from deck
        boolean Special = true;
        Card drawnCard = null;
        while(Special){
            List<Card> deckCards = deck.listCards();
            Random random = new Random();
            int index = random.nextInt(deckCards.size()); // Generate a random index
            drawnCard = deckCards.get(index); // Get the card at that index

            // place the random card
            this.getPlayGround().add(drawnCard);

            // check if placed card is special
            if (!(drawnCard instanceof SpecialCard))
                Special = false;
        }

        System.out.println("The "+drawnCard+" was placed into the playground");
    }

    // 5: game flow
    public void gameFlow(){
        List<Player> players = this.getActivePlayers();

        int i = 0;
        while(players.size() > 2){

            Player activePlayer = players.get(i);

            // set counter value
            i = FlowCounter.moveFlow(this, i, players.size());

            Player nextPlayer = players.get(i);

            if(!(activePlayer.placeCard(this))){
                // the player hasn't placed a card
                if(!(activePlayer.draw(this))){
                    // the player wasn't able to draw a card
                    System.out.println("The Game has ended because the deck is empty");
                    break;
                }
                System.out.println("bot"+activePlayer.getId()+" has drawn 1 card now he has "+activePlayer.getCards().size()+" cards" );

                // the player draw a card
            }else{
                // the player has placed a card
                Card placedCard = this.getPlayGround().getLast();
                System.out.println("bot"+activePlayer.getId()+" has placed a "+placedCard+" now he has "+activePlayer.getCards().size()+" cards");

                // check if player has won
                if (activePlayer.getCards().isEmpty()){
                    System.out.println("bot"+activePlayer.getId()+" has no cards left");
                    this.removePlayer(activePlayer);
                }

                // run the card's effect
                if (placedCard instanceof SpecialCard specialCard){
                    specialCard.getSpecialEffect().execute(this, activePlayer, nextPlayer, i);
                    if (this.isSkip()){
                        // placed card was a skip card
                        i = FlowCounter.moveFlow(this, i, players.size());
                        System.out.println("bot"+nextPlayer.getId()+" was skipped");
                        this.setSkip(false);
                    }
                }
            }
        }
    }

    // initialization template method
    public final void play(){
        //1
        this.setMyRule();

        //2
        this.setMyDeck();

        //3
        if (!(createPlayers(this, 4))){
            // TODO: raise exception
        }else{
            //4
            addToPlayGround();

            //5
            gameFlow();
        }
    }
}
