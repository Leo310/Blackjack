package hwr.oop;

import org.assertj.core.internal.bytebuddy.build.ToStringPlugin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void dealerDrawsAndTheHandCountChangesAccordinglyToTheCardValue() {
        Card card = new Card("Ace", 11);
        assertThat(dealer.getHandCount()).isEqualTo(0);
        dealer.drawCard(card);
        assertThat(dealer.getHandCount()).isEqualTo(11);
    }

    /*@Test
    void dealerExposesRightFistCardValue() {
        Card card = new Card("Ace", 11);
        Dealer dealer = new Dealer();
        String expectedOutput = "Exposed First Card is a Card [name=Ace]";
        assertEquals("Exposed First Card is a Card [name=Ace]", dealer.exposeFirstCard().toString());
    }*/

}
