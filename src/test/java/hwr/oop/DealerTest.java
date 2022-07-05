package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

// TODO one way to write Assertions
import static org.assertj.core.api.Assertions.assertThat;

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
        Assertions.assertThatThrownBy(() -> dealer.dealCard(), "Deck is empty");

    }

    @Test
    void deckHasValidCards() {
        dealer.createNewDeck();
        for (int i = 0; i < 52; i++) {
            Card card = dealer.dealCard();
            if (card.getName() == "King" || card.getName() == "Queen" || card.getName() == "Jack") {
                Assertions.assertThat(card.getValue()).isEqualTo(10);
            } else if (card.getValue() == 1 || card.getValue() == 11) {
                Assertions.assertThat(card.getName()).isEqualTo("Ace");
            } else {
                Assertions.assertThat(card.getValue()).isLessThan(11).isGreaterThan(1)
                        .isEqualTo(Integer.valueOf(card.getName()));
            }
        }
    }

    @Test
    void dealerDrawsAndTheHandCountChangesAccordinglyToTheCardValue() {
        Card card = new Card("Ace", 11);
        assertThat(dealer.getHandCount()).isEqualTo(0);
        dealer.drawCard(card);
        assertThat(dealer.getHandCount()).isEqualTo(11);
    }

    @Test
    void dealerDealsCardToHimselfAndHandCountChangesAccordingly() {
        dealer.createNewDeck();
        Card card = dealer.dealCard();
        assertThat(dealer.getHandCount()).isEqualTo(0);
        dealer.drawCard(card);
        assertThat(dealer.getHandCount()).isEqualTo(card.getValue());
    }

    @Test
    void dealerTriesToDealACardFromAnEmptyDeckButFails() {
        try {
            dealer.dealCard();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void dealerGetsACardAndExposesItAsFirstCardAnTheCardValueIsCorrect() {
        Card card = new Card("Ace", 11);
        dealer.drawCard(card);
        assertThat(dealer.exposeFirstCard())
                .isEqualTo("Exposed First Card is a Card [name=Ace]\n");
    }

    @Test
    void dealerGetsTwoAcesAndTheSecondGetsTheValueOfOne() {
        Card firstAce = new Card("Ace", 11);
        Card secondAce = new Card("Ace", 11);
        dealer.drawCard(firstAce);
        assertThat(dealer.getHandCount()).isEqualTo(11);
        dealer.drawCard(secondAce);
        assertThat(dealer.getHandCount()).isEqualTo(12);
    }

    @Test
    void dealerGetsACardAndEmptiesHisHand() {
        dealer.createNewDeck();
        dealer.drawCard(dealer.dealCard());
        assertThat(dealer.getHandCount()).isNotEqualTo(0);
        dealer.resetHand();
        assertThat(dealer.getHandCount()).isEqualTo(0);
    }


}
