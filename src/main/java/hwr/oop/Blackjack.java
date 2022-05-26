package hwr.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Blackjack {
    List<Player> players = new ArrayList<>();
    Dealer dealer;
    final int upperBetLimit;

    public Blackjack(int upperBetLimit) {
        this.upperBetLimit = upperBetLimit;
        this.dealer = new Dealer();
    }

    void addPlayer(String name, int bankroll) {
        players.add(new Player(name, bankroll));
    }

    void drawFirstHand() {
        // Every player draws two cards
        for (Player player : players) {
            player.hit(dealer.dealCard());
            player.hit(dealer.dealCard());
        }
        // Dealer also draws two cards
        dealer.drawCard(dealer.dealCard());
        // TODO dealer exposes one card
        dealer.drawCard(dealer.dealCard());
    }

    void playersSetStake() {
        // Every player sets its stakes
        Scanner keyboardScanner = new Scanner(System.in);
        for (Player player : players) {
            // TODO check stakes
            int stakeInput = keyboardScanner.nextInt();
            player.setStake(stakeInput);
        }
    }

    void play() {
        if (players.isEmpty())
            System.out.println("No players");
        else {
            // TODO
            // set stakes
            // drawFirstHand
            // if player wants to hit, hit! until no one wants to hit anymore or game over
            // dealer draws cards until more value greater than 16
            // compare hands of dealer and every player
            // cash out
            // play again?
        }
    }
}
