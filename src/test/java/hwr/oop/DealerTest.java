package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class DealerTest {
    Dealer dealer;

    @BeforeEach
    void createDealer() {
        dealer = new Dealer();
    }

    @Test
    void deckHas52Cards() {
        dealer.createNewDeck();
        for (int i = 0; i < 52; i++) {
            dealer.dealCard();
        }

        Assertions.assertThat(dealer.dealCard()).isNull();
    }

    @Test
    void deckHasValidCards() {
        dealer.createNewDeck();
        Card card = dealer.dealCard();
        while (card != null) {
            card = dealer.dealCard();
            if (card.getName() == "King" || card.getName() == "Queen" || card.getName() == "Jack") {
                Assertions.assertThat(card.getValue()).isEqualTo(10);
            } else if (card.getValue() == 1 || card.getValue() == 11) {
                Assertions.assertThat(card.getName()).isEqualTo("Ace");
            } else {
                Assertions.assertThat(card.getValue()).isLessThan(11).isGreaterThan(1)
                        .isEqualTo(Integer.valueOf(card.getName()));
            }
            card = dealer.dealCard();
        }
        ;
    }

}
