package model;

import enums.Coin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinsTest {
    Coins coins;

    @BeforeEach
    void init() {
        coins = new Coins();

        coins.charge(Coin.FIVE_HUNDRED, 3);
        coins.charge(Coin.ONE_HUNDRED, 3);
        coins.charge(Coin.FIFTY, 3);
        coins.charge(Coin.TEN, 3);
    }

    @Test
    @DisplayName("동전 충전 후 각 동전 값 확인")
    void amountTest() {
        assertAll(
                () -> assertEquals(coins.amount(Coin.FIVE_HUNDRED), 1500),
                () -> assertEquals(coins.amount(Coin.ONE_HUNDRED), 300),
                () -> assertEquals(coins.amount(Coin.FIFTY), 150),
                () -> assertEquals(coins.amount(Coin.TEN), 30)
        );
    }

    @Test
    @DisplayName("모든 동전의 금액 합 확인")
    void totalAmountTest() {
        assertEquals(coins.totalAmount(), 1980);
    }
}