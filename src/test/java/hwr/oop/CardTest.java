package hwr.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CardTest {

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

    // @Test
    // void setAceValue() {
    // Card card1 = new Card("King", 10);
    // try {
    // card1.setAceValue(11);
    // } catch (RuntimeException e) {
    // e.printStackTrace();
    // }
    // Card card2 = new Card("Ace", 1);
    // Card card3 = new Card("Ace", 1);
    // try {
    // card3.setAceValue(12);
    // } catch (RuntimeException e) {
    // e.printStackTrace();
    // }
    // }
}
