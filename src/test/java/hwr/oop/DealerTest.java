package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DealerTest {
    Dealer dealer;

    @BeforeEach
    void createDealer() {
        dealer = new Dealer();
    }

    @Test
    void dealerCreatesDeck_deals52Cards_DeckIsEmptyInTheEnd() {
        dealer.createNewDeck();
        for (int i = 0; i < 52; i++) {
            dealer.dealCard();
        }
        assertThatThrownBy(() -> dealer.dealCard(), "Deck is empty");

    }

    @Test
    void eachCardInDeck_HasTheRightName_AccordingToTheValue() {
        dealer.createNewDeck();
        for (int i = 0; i < 52; i++) {
            Card card = dealer.dealCard();
            if (card.getName() == "King" || card.getName() == "Queen" || card.getName() == "Jack") {
                assertThat(card.getValue()).isEqualTo(10);
            } else if (card.getValue() == 1 || card.getValue() == 11) {
                assertThat(card.getName()).isEqualTo("Ace");
            } else {
                assertThat(card.getValue()).isLessThan(11).isGreaterThan(1)
                        .isEqualTo(Integer.valueOf(card.getName()));
            }
        }
    }

    @Test
    void dealerDraws_TheHandCountChanges_AccordinglyToTheCardValue() {
        Card card = new Card("Ace", 11);
        assertThat(dealer.getHandCount()).isEqualTo(0);
        dealer.drawCard(card);
        assertThat(dealer.getHandCount()).isEqualTo(11);
    }

    @Test
    void dealerDealsCardToHimself_HandCountChanges_Accordingly() {
        dealer.createNewDeck();
        Card card = dealer.dealCard();
        assertThat(dealer.getHandCount()).isEqualTo(0);
        dealer.drawCard(card);
        assertThat(dealer.getHandCount()).isEqualTo(card.getValue());
    }

    @Test
    void dealerTriesToDealACard_FromAnEmptyDeck_Fails() {
        try {
            dealer.dealCard();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void dealerGetsCard_ExposesItAsFirstCard_TheCardValueIsCorrect() {
        Card card = new Card("Ace", 11);
        dealer.drawCard(card);
        assertThat(dealer.exposeFirstCard())
                .isEqualTo("Exposed First Card is a Card [name=Ace]\n");
    }

    @Test
    void dealerGetsTwoAces_TheSecondGetsTheValueOfOne() {
        Card firstAce = new Card("Ace", 11);
        Card secondAce = new Card("Ace", 11);
        dealer.drawCard(firstAce);
        assertThat(dealer.getHandCount()).isEqualTo(11);
        dealer.drawCard(secondAce);
        assertThat(dealer.getHandCount()).isEqualTo(12);
    }

    @Test
    void dealerGetsACard_EmptiesHisHand() {
        dealer.createNewDeck();
        dealer.drawCard(dealer.dealCard());
        assertThat(dealer.getHandCount()).isNotEqualTo(0);
        dealer.resetHand();
        assertThat(dealer.getHandCount()).isEqualTo(0);
    }

}
