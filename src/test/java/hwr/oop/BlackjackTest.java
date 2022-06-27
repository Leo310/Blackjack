package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BlackjackTest {

    Blackjack bj;

    @BeforeEach
    void createBlackjack() {
        bj = new Blackjack(100000);
    }

    @Test
    void addPlayer() {
        assertThat(bj.players.isEmpty()).isTrue();
        assertThat(bj.addPlayer("Pete", 10)).isFalse();
        assertThat(bj.addPlayer("Steve", 1000)).isTrue();
        assertThat(bj.players.isEmpty()).isFalse();

    }

    @Test
    void removePlayersWithLowBankrolls() {
        assertThat(bj.players.isEmpty()).isTrue();
        bj.addPlayer("Pete", 2000);
        bj.removePlayersWithLowBankrolls();
        assertThat(bj.players.isEmpty()).isFalse();
        bj.players.get(0).wins(-1990);
        bj.removePlayersWithLowBankrolls();
        assertThat(bj.players.isEmpty()).isTrue();

    }

    @Test
    void evaluateWinners() {

    }

    @Test
    void startGame() {
    }

    @Test
    void play() {
    }
}