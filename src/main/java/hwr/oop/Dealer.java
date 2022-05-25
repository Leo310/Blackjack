package hwr.oop;

public class Dealer {
    private List deck;
    private List hand;

    public Dealer() {
        this.deck = new ArrayList<Card>();
        // Cards from 2 to 10
        for (int i = 2; i < 11; i++)
            this.deck.add(new Card(i, Integer.toString(i)));

        for (int i = 0; i < 4; i++) {
            this.deck.add(new Card(10, "Jack"));
            this.deck.add(new Card(10, "Queen"));
            this.deck.add(new Card(10, "King"));
            this.deck.add(new Card(1, "Ace"));
        }

        this.hand = new ArrayList<Card>();
    }

    public void shuffleDeck() {

    }

    public HashSet<Card> dealCards(int numberOfCards) {
    }
}
