package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BlackjackTest {

    Blackjack bj;

    @BeforeEach
    void create_BlackjackGame() {
        bj = new Blackjack(1000);
    }

    @Test
    void addPlayer() {
        assertThat(bj.addPlayer("Hans", 999)).isFalse();
        assertThat(bj.addPlayer("Steve", 1000)).isTrue();
    }

    @Test
    void blackjack_Play() {
        assertThat(bj.play()).isFalse();
        bj.addPlayer("Hans", 1000);
        bj.addPlayer("Peter", 3000);
        bj.addPlayer("Luis", 3000);
        assertThat(bj.play()).isTrue();
    }
}
