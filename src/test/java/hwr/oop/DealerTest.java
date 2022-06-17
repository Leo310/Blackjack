package hwr.oop;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class DealerTest {

    @Test
    void deckHas52Cards() {
        Dealer dealer = new Dealer();
        dealer.createNewDeck();
        for (int i = 0; i < 52; i++) {
            dealer.dealCard();
        }
        Assertions.assertThatThrownBy(() -> {
            dealer.dealCard();
        });
    }

}
