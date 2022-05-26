package hwr.oop;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private int stake;
    private int bankroll;
    private boolean wantsToHit;

    public Player(String name, int bankroll) {
        this.hand = new ArrayList<Card>();
        this.name = name;
        this.bankroll = bankroll;
    }

    public void setStake(int stake) {
        this.stake = stake;
    }

    public void hit(Card card) {
        hand.add(card);
    }

    public boolean wantsToHit() {
        return this.wantsToHit;
    }
}
