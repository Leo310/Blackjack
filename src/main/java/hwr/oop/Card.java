package hwr.oop;

class Card {
    private final String name;
    private int value;

    Card (String name, int value) {
        this.name = name;
        this.value = value;
    }

    int getValue() { return value; }

    String getName() { return name; }

    void setAceValue(int value) throws Exception {
        if (name == "Ace") {
            if (value == 11) {
                this.value = 11;
            } else if (value == 1) {
                this.value = 1;
            } else {
                throw new Exception("An Ace can only have the values 1 or 11!");
            }
        } else {
            throw new Exception("Only an Ace can change its value!");
        }
    }
}
