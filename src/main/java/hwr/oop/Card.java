package hwr.oop;

class Card {
    private final String name;
    private int value;

    Card(String name, int value) {
        this.name = name;
        this.value = value;
        // isValidCard();
    }

    // TODO check for valid values

    boolean isValidCard() {
        if (this.name == "King" || this.name == "Queen" || this.name == "Jack") {
            if (this.value == 10) {
                return true;
            } else {
                throw new RuntimeException("Name does not match value!");
            }
        } else if (this.name == "Ace" && (this.value == 1 || this.value == 11)) {
            return true;
        } else {
            if (this.name == String.valueOf(this.value)) {
                return true;
            } else {
                throw new RuntimeException("Name does not match value!");
            }
        }
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
