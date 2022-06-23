package hwr.oop;

class Card {
    private final String name;
    private int value;

    Card(String name, int value) {
        this.name = name;
        this.value = value;
        // isValidCard();
    }

    @Override
    public String toString() {
        return "Card [name=" + name + "]";
    }

    int getValue() {
        return this.value;
    }

    String getName() {
        return this.name;
    }

    void setAceValueToOne() {
        if (this.name == "Ace") {
            this.value = 1;
        }
    }
}
