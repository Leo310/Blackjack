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
        dealer.exposeFirstCard();
        // TODO dealer exposes one card
        dealer.drawCard(dealer.dealCard());
    }

    void playersHit() {
        for (Player player:players) {
            player.hit(dealer.dealCard());
        }
    }
    void dealerDrawsCards() {
        // TODO if hand value is less or equal to 16
        dealer.dealCard();
    }

    void playersSetStake() {
        // Every player sets its stakes
        Scanner keyboardScanner = new Scanner(System.in);
        for (Player player : players) {
            // TODO check stakes
            int bankroll = player.getBankroll();
            System.out.print(bankroll);
            int stakeInput = 0;
            while (stakeInput == 0 || stakeInput > bankroll){
                stakeInput = keyboardScanner.nextInt();
                if (stakeInput > bankroll) {
                    throw new RuntimeException("Your stake cannot be bigger than your bankroll!");
                }
            }
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
