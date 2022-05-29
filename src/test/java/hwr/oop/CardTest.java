package hwr.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void isValidCard() {
        Card card1 = new Card("King", 10);
        assertThat(card1.isValidCard()).isTrue();
        Card card2 = new Card("5", 6);
        assertThat(card2.isValidCard()).isFalse();
    }

    @Test
    void getValue() {
        Card card = new Card("King", 10);
        assertThat(card.getValue()).isEqualTo(10);
    }

    @Test
    void getName() {
        Card card = new Card("5", 5);
        assertThat(card.getName()).isNotEqualTo("6");
    }

    @Test
    void setAceValue() {
        Card card1 = new Card("King", 10);

        Card card2 = new Card("Ace", 1);
    }
}