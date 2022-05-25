package hwr.oop;

class Card {
    private final String name;
    private final int value;

    Card (String name, int value) {
        this.name = name;
        this.value = value;
    }

    int getValue() { return value; }
    String getName() { return name; }
}
