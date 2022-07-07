package hwr.oop;

import java.util.ArrayList;
import java.util.List;

public class Blackjack {
    private List<Player> players = new ArrayList<>();
    private Dealer dealer;
    private final int minimumStake;
    private int bank;

    public Blackjack(int minimumStake) {
        this.minimumStake = minimumStake;
        this.dealer = new Dealer();
    }

    private void removePlayersWithLowBankrolls() {
        this.players.removeIf(player -> {
            if ((player.getBankroll() < this.minimumStake)) {
                System.out.println(player + " doesnt have enough money to play Blackjack anymore");
                return true;
            }
            return false;
        });
    }

    private void evaluateWinners() {
        // compare hands of dealer and every player
        for (Player player : players) {
            if (player.getHandCount() > 21) {
                this.bank += player.loses();
            } else if (player.getHandCount() == 21) {
                int winAmount = (player.getStake() / 2) * 3;
                player.wins(winAmount);
                this.bank -= winAmount;
            } else if (this.dealer.getHandCount() == player.getHandCount()) {
                player.wins(0);
            } else if (this.dealer.getHandCount() < player.getHandCount() || this.dealer.getHandCount() > 21) {
                int winAmount = player.getStake();
                player.wins(winAmount);
                this.bank -= winAmount;
            } else {
                // if player has more equal or more than 17 but still less than the dealer
                this.bank += player.loses();
            }
        }
    }

    private void runGameLogic() throws RuntimeException {
        // Every player sets their stake and draws two cards
        for (Player player : this.players) {
            player.setStake();
            player.hit(dealer.dealCard());
            player.hit(dealer.dealCard());
        }
        // Dealer also draws two cards and faces up first one
        this.dealer.drawCard(this.dealer.dealCard());
        this.dealer.drawCard(this.dealer.dealCard());
        System.out.print(this.dealer.exposeFirstCard());

        if (this.dealer.getHandCount() == 21) {
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
        while (this.dealer.getHandCount() <= 16) {
            this.dealer.drawCard(this.dealer.dealCard());
        }
    }

    public boolean addPlayer(String name, int bankroll) {
        if (bankroll < this.minimumStake) {
            System.out.println(name + " has not enough money to play Blackjack");
            return false;
        }
        System.out.println("Added player: " + name);
        this.players.add(new Player(name, bankroll, this.minimumStake));
        return true;
    }

    public boolean play() {
        // setup
        removePlayersWithLowBankrolls();
        if (this.players.isEmpty()) {
            System.out.println("No players");
            return false;
        }
        this.dealer.createNewDeck();

        // game Logic
        try {
            runGameLogic();
        } catch (EmptyCardDeckException e) {
            // If deck is empty. Should never be empty
            System.out.println(e);
            return false;
        }
        evaluateWinners();
        System.out.println("Dealer has a hand count of " + dealer.getHandCount() + ". Bank value: " + this.bank + '\n');
        this.dealer.resetHand();
        return true;
    }
}
