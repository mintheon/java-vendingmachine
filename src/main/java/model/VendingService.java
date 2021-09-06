package model;

import enums.Coin;
import utils.CoinUtils;

import java.util.EnumSet;

public class VendingService {
    private final CoinUtils coinUtils = new CoinUtils();

    private Coins coins;

    public VendingService(int amountOfCoin, Items items, int amountOfMoney) {
        chargeCoins(amountOfCoin);
    }

    public void chargeCoins(int amountOfCoin) {
        Coins coins = new Coins();

        int amount = amountOfCoin;

        while (amount > 0) {
            for (Coin coin : EnumSet.allOf(Coin.class)) {
                int randomCount = coinUtils.generateRandomCoinCount(coin, amount);

                coins.chargeCoin(coin, randomCount);
                amount -= coin.carculateAmount(randomCount);
            }
        }

        this.coins = coins;
    }
}
