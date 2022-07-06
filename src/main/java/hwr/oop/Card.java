package hwr.oop;

class Card {
    private final String name;
    private int value;

    public Card(String name, int value) {
        this.name = name;
        this.value = value;
        // isValidCard();
    }

    @Override
    public String toString() {
        return "Card [name=" + name + "]";
    }

    public int getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public void setAceValueToOne() {
        if (this.name == "Ace") {
            this.value = 1;
        }
    }
}
