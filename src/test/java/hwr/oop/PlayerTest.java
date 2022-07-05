package hwr.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    Player player;

    @BeforeEach
    void createPlayer() {
        player = new Player("Pete", 1000, 10);
    }

    @Test
    void playerSetsStake_StakeIsInBetween_MinimumStake_And_HisBankroll() {
        player.setStake();
        assertThat(player.getStake()).isLessThan(player.getBankroll() + 1).isGreaterThan(player.getMinimumStake() - 1);
    }


    @Test
    void playerSetsStake_Loses_BankrollChangesAccordingly() {
        player.setStake();
        player.loses();
        assertThat(player.getHandCount() == 0).isTrue();
        assertThat(player.getBankroll()).isEqualTo(1000 - player.getStake());
    }

    @Test
    void playerWins_BankrollChangesAccordingly() {
        player.wins(100);
        assertThat(player.getHandCount() == 0).isTrue();
        assertThat(player.getBankroll()).isEqualTo(1100);
    }

    @Test
    void playerHits_TheHandCountChangesAccordingly_ToTheCardValue() {
        Card card = new Card("Ace", 11);
        assertThat(player.getHandCount()).isEqualTo(0);
        player.hit(card);
        assertThat(player.getHandCount()).isEqualTo(11);
    }

    @Test
    void playerWantsToHit_UntilHisHandCountIsAbove16() {
        Card aceCard = new Card("Ace", 11);
        Card kingCard = new Card("King", 10);
        Card sixCard = new Card("6", 6);
        player.hit(kingCard);
        player.setWantsToHit();
        assertThat(player.wantsToHit()).isTrue();
        player.hit(sixCard);
        player.setWantsToHit();
        assertThat(player.wantsToHit()).isTrue();
        player.hit(aceCard);
        player.setWantsToHit();
        assertThat(player.wantsToHit()).isFalse();
    }

}
