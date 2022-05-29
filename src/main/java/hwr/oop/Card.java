package hwr.oop;

class Card {
    private final String name;
    private int value;

    Card(String name, int value) {
        this.name = name;
        this.value = value;
        isValidCard();
    }

    // TODO check for valid values

    boolean isValidCard() {
        if (name == "King" || name == "Queen" || name == "Jack") {
            if (value == 10) {
                return true;
            } else {
                throw new RuntimeException("Name does not match value!");
            }
        } else if (name == "Ace" && (value == 1 || value == 11)) {
            return true;
        } else {
            if (name == String.valueOf(value)) {
                return true;
            } else {
                throw new RuntimeException("Name does not match value!");
            }
        }
    }

    int getValue() {
        return value;
    }

    String getName() {
        return name;
    }

    void setAceValue(int value) throws Exception {
        if (name == "Ace") {
            if (value == 11) {
                this.value = 11;
            } else if (value == 1) {
                this.value = 1;
            } else {
                // TODO maybe new exception
                throw new Exception("An Ace can only have the values 1 or 11!");
            }
        } else {
            throw new Exception("Only an Ace can change its value!");
        }
    }
}
