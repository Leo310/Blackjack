package hwr.oop;

import java.util.ArrayList;
import java.util.List;

// TODO coherent this in classes
public class Blackjack {
    List<Player> players = new ArrayList<>();
    Dealer dealer;
    final int upperBetLimit;
    int bank;

    public Blackjack(int upperBetLimit) {
        this.upperBetLimit = upperBetLimit;
        this.dealer = new Dealer();
    }

    void addPlayer(String name, int bankroll) {
        // TODO check if players bankroll is bigger than minimumStake
        players.add(new Player(name, bankroll, upperBetLimit / 100));
    }

    // TODO refactor methods out
    void play() {
        if (players.isEmpty())
            System.out.println("No players");
        else {
            dealer.createNewDeck();
            // Every player sets its stakes
            for (Player player : this.players) {
                player.setStake();
            }

            // Every player draws two cards
            for (Player player : this.players) {
                player.hit(dealer.dealCard());
                player.hit(dealer.dealCard());
            }
            // Dealer also draws two cards and faces up first one
            dealer.drawCard(dealer.dealCard());
            dealer.drawCard(dealer.dealCard());
            dealer.exposeFirstCard();
            // TODO players place insurance and dealer checks their down card to see if they
            // have blackjack. if they have expose it and conclude the game
            if (dealer.getHandCount() == 21) {
                System.out.println("The dealer has Blackjack");
                for (Player player : this.players) {
                    if (player.getHandCount() != 21) {
                        this.bank += player.loses();
                    }
                }
                return;
            }

            // if player wants to hit, hit! until no one wants to hit anymore or game over
            for (Player player : this.players) {
                player.setWantsToHit();
                while (player.wantsToHit() && player.getHandCount() <= 21) {
                    player.hit(dealer.dealCard());
                    player.setWantsToHit();
                }
            }
            // dealer draws cards until more value greater than 16
            while (dealer.getHandCount() <= 16) {
                dealer.drawCard(dealer.dealCard());
            }

            // compare hands of dealer and every player
            for (Player player : players) {
                if (player.getHandCount() > 21) {
                    this.bank += player.loses();
                } else if (player.getHandCount() == 21) {
                    int winAmount = (player.getStake() / 2) * 3;
                    player.wins(winAmount);
                    this.bank -= winAmount;
                } else if (dealer.getHandCount() == player.getHandCount()) {
                    player.wins(0);
                } else if (dealer.getHandCount() < player.getHandCount() || dealer.getHandCount() > 21) {
                    int winAmount = player.getStake();
                    player.wins(winAmount);
                    this.bank -= winAmount;
                } else {
                    // if player has more equal or more than 17 but still less than the dealer
                    this.bank += player.loses();
                }
            }
            System.out.println("Dealer has a hand count of " + dealer.getHandCount());
            dealer.resetHand();
        }
    }

    public static void main(String[] args) {
        Blackjack bj = new Blackjack(20000);
        bj.addPlayer("Hans", 1000);
        bj.addPlayer("Peter", 3000);
        // for (int i = 0; i < 5; i++) {
        //     bj.play();
        // }
        bj.play();
    }
}
