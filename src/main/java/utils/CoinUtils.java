package utils;

import enums.Coin;

import java.util.Random;

public class CoinUtils {
    private static final Random random = new Random();

    public int generateRandomCoinCount(Coin coin, int chargeAmount) {
        if (chargeAmount <= 0) {
            return 0;
        }

        int maxCount = coin.maxCount(chargeAmount);
        if (maxCount == 0) {
            return 0;
        }

        return random.nextInt(maxCount + 1);
    }
}
