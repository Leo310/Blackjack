package hwr.oop;

public class Player {
    private String name;
    private Set hand;
    private int stake;
    private int bankroll;
    private boolean wantsToHit;

    public Player(String name, int bankroll) {
        this.hand = new HashSet<Card>();
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
