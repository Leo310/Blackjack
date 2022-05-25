package hwr.oop;

import java.util.ArrayList;
import java.util.Collection;

public class Blackjack {
    Collection<Player> players = new ArrayList<>();
    Dealer dealer;
    final int upperBetLimit;

    Blackjack (int upperBetLimit) {
        this.upperBetLimit = upperBetLimit;
    }

    void play(){}
}
