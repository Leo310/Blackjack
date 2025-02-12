package hwr.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Dealer {
    private List<Card> deck;
    private List<Card> hand;

    public Dealer() {
        this.hand = new ArrayList<Card>();
    }

    void createNewDeck() {
        this.deck = new ArrayList<Card>();
        // Cards from 2 to 10
        for (int i = 2; i < 11; i++) {
            // 4 times
            for (int j = 0; j < 4; j++) {
                this.deck.add(new Card(Integer.toString(i), i));
            }
        }

        for (int i = 0; i < 4; i++) {
            this.deck.add(new Card("Jack", 10));
            this.deck.add(new Card("Queen", 10));
            this.deck.add(new Card("King", 10));
            this.deck.add(new Card("Ace", 11));
        }
    }

    int getHandCount() {
        int count = 0;
        for (Card card : hand) {
            count += card.getValue();
        }
        return count;
    }

    Card dealCard() {
        if (this.deck.isEmpty()) {
            throw new EmptyCardDeckException("Deck is empty");
        }
        Random randomNumberGenerator = new Random();
        int randomIndex = randomNumberGenerator.nextInt(this.deck.size());
        Card randomCard = this.deck.remove(randomIndex);
        return randomCard;
    }

    void drawCard(Card card) {
        if (getHandCount() > 10 && card.getName() == "Ace") {
            card.setAceValueToOne();
        }
        this.hand.add(card);
    }

    String exposeFirstCard() {
        // System.out.printf("Exposed First Card is a %s\n", hand.get(0));
        return "Exposed First Card is a " + hand.get(0) + "\n";
    }

    void resetHand() {
        this.hand = new ArrayList<Card>();
    }
}
