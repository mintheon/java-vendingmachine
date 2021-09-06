package enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinTest {

    @Test
    @DisplayName("주어진 금액의 동전 최대 개수 반환")
    void maxCountTest() {
        assertAll(
                () -> assertEquals(Coin.FIVE_HUNDRED.maxCount(500), 1),
                () -> assertEquals(Coin.ONE_HUNDRED.maxCount(500), 5),
                () -> assertEquals(Coin.FIFTY.maxCount(500), 10),
                () -> assertEquals(Coin.TEN.maxCount(500), 50)
        );
    }

    @Test
    @DisplayName("각 동전 개수로 금액 계산")
    void carculateAmount() {
        assertAll(
                () -> assertEquals(Coin.FIVE_HUNDRED.carculateAmount(5), 2500),
                () -> assertEquals(Coin.ONE_HUNDRED.carculateAmount(5), 500),
                () -> assertEquals(Coin.FIFTY.carculateAmount(5), 250),
                () -> assertEquals(Coin.TEN.carculateAmount(5), 50)
        );
    }
}