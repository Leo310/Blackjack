package hwr.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void setStake() {
        Player player = new Player("Pete", 1000, 10);
        player.setStake();
        assertThat(player.getStake()).isLessThan(player.getBankroll() + 1).isGreaterThan(player.getMinimumStake() - 1);
    }

    @Test
    void testSetStake() {
    }

    @Test
    void getStake() {
        Player player = new Player("Pete", 1000, 10);
        assertThat(player.getStake()).isLessThan(1000);
    }

    @Test
    void loses() {
        Player player = new Player("Pete", 1000, 10);
        player.loses();
        assertThat(player.getBankroll()).isEqualTo(1000 - player.getStake());
    }

    @Test
    void wins() {
        Player player = new Player("Pete", 1000, 10);
        player.wins(100);
        assertThat(player.getBankroll()).isEqualTo(1100);
    }

    @Test
    void getBankroll() {
    }

    @Test
    void hit() {
    }

    @Test
    void getHandCount() {
    }

    @Test
    void setWantsToHit() {
    }

    @Test
    void testSetWantsToHit() {
    }

    @Test
    void wantsToHit() {
    }
}