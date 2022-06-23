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

    void setAceValue(int value) throws RuntimeException {
        if (this.name == "Ace") {
            if (value == 11) {
                this.value = 11;
            } else if (value == 1) {
                this.value = 1;
            } else {
                throw new RuntimeException("An Ace can only have the values 1 or 11!");
            }
        } else {
            throw new RuntimeException("Only an Ace can change its value!");
        }
    }
}
