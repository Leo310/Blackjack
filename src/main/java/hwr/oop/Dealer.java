package hwr.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dealer {
    private List<Card> deck;
    private List<Card> hand;

    public Dealer() {
        createNewDeck();
        this.hand = new ArrayList<Card>();
    }

    public void createNewDeck() {
        this.deck = new ArrayList<Card>();
        // Cards from 2 to 10
        for (int i = 2; i < 11; i++)
            this.deck.add(new Card(Integer.toString(i), i));

        for (int i = 0; i < 4; i++) {
            this.deck.add(new Card("Jack", 10));
            this.deck.add(new Card("Queen", 10));
            this.deck.add(new Card("King", 10));
            this.deck.add(new Card("Ace", 1));
        }
    }

    // public void shuffleDeck() {
    // Random rand = new Random();
    // // count of shuffles. (higher count better shuffle)
    // for (int j = 3; j < rand.nextInt(10); j++) {
    // // removes card at random index and adds it at the end of the deck
    // for (int i = 0; i < this.deck.size(); i++) {
    // int randomIndex = rand.nextInt(this.deck.size());
    // Card randomCard = this.deck.remove(randomIndex);
    // this.deck.add(randomCard);
    // }
    // }
    // }

    public Card dealCard() {
        Random randomNumberGenerator = new Random();
        int randomIndex = randomNumberGenerator.nextInt(this.deck.size());
        Card randomCard = this.deck.remove(randomIndex);
        return randomCard;
    }

    public void drawCard(Card card) {
        this.hand.add(card);
    }

    public List<Card> exposeFirstCard() {
        // TODO just return the card name, value
        return hand;
    }
}
