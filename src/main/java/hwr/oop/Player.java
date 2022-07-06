package hwr.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private String name;
    private List<Card> hand;
    private int stake;
    private int minimumStake;
    private int bankroll;
    private boolean wantsToHit;

    public Player(String name, int bankroll, int minimumStake) {
        this.hand = new ArrayList<Card>();
        this.name = name;
        this.bankroll = bankroll;
        this.minimumStake = minimumStake;
    }

    void setStake() {
        Random rand = new Random();
        // need to add +1 in nextInt, because nextInt(0) throws IllegalArgumentException
        int randomStake = rand.nextInt(bankroll - this.minimumStake + 1) + minimumStake - 1;
        this.stake = randomStake;
    }

    int getStake() {
        return this.stake;
    }

    int loses() {
        this.bankroll -= this.stake;
        System.out.println(this + " loses");
        this.hand = new ArrayList<Card>();
        return this.stake;
    }

    void wins(int amount) {
        this.bankroll += amount;
        if (amount == 0) {
            System.out.println(this + " has a draw");
        } else {
            System.out.println(this + " wins");
        }
        this.stake = 0;
        this.hand = new ArrayList<Card>();
    }

    int getBankroll() {
        return bankroll;
    }

    int getMinimumStake() {
        return minimumStake;
    }

    void hit(Card card) {
        if (getHandCount() > 10 && card.getName() == "Ace") {
            card.setAceValueToOne();
        }
        this.hand.add(card);
    }

    int getHandCount() {
        int count = 0;
        for (Card card : hand) {
            count += card.getValue();
        }
        return count;
    }

    void setWantsToHit() {
        this.wantsToHit = getHandCount() <= 16;
    }

    boolean wantsToHit() {
        return this.wantsToHit;
    }

    String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Player [name=" + this.name + ", handCount=" + getHandCount() + ", stake=" + this.stake + ", bankroll="
                + this.bankroll
                + "]";
    }
}
