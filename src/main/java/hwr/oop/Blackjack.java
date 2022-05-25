package hwr.oop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Blackjack {
    List<Player> players = new ArrayList<>();
    Dealer dealer;
    final int upperBetLimit;

    Blackjack (int upperBetLimit) {
        this.upperBetLimit = upperBetLimit;
    }

    void play(){}
}
