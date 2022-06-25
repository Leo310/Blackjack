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

    public void setStake() {
        Random rand = new Random();
        int randomStake = rand.nextInt(bankroll - this.minimumStake) + minimumStake;
        this.stake = randomStake;
    }

    public void setStake(int stake) {
        // TODO add bounds checking
        this.stake = stake;
    }

    public int getStake() {
        return this.stake;
    }

    public int loses() {
        this.bankroll -= this.stake;
        System.out.println(this.toString() + " loses");
        this.hand = new ArrayList<Card>();
        return this.stake;
    }

    public void wins(int amount) {
        if (amount == 0) {
            System.out.println(this.toString() + " has a draw");
        } else {
            this.bankroll += amount;
            System.out.println(this.toString() + " wins");
            this.hand = new ArrayList<Card>();
        }
    }

    public int getBankroll() {
        return bankroll;
    }

    public int getMinimumStake() {
        return minimumStake;
    }

    public void hit(Card card) {
        if (getHandCount() > 10 && card.getName() == "Ace") {
            card.setAceValueToOne();
        }
        this.hand.add(card);
    }

    public int getHandCount() {
        int count = 0;
        for (Card card : hand) {
            count += card.getValue();
        }
        return count;
    }

    public void setWantsToHit() {
        this.wantsToHit = getHandCount() <= 16;
    }

    public void setWantsToHit(boolean hit) {
        this.wantsToHit = hit;
    }

    public boolean wantsToHit() {
        return this.wantsToHit;
    }

    @Override
    public String toString() {
        return "Player [name=" + name + ", handCount=" + getHandCount() + ", stake=" + stake + ", bankroll=" + bankroll
                + "]";
    }
}
