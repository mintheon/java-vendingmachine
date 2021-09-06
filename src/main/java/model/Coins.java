package model;

import enums.Coin;

import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class Coins {
    public static final int MIN_COUNT = 0;

    private Map<Coin, Integer> coins;

    public Coins() {
        this.coins = new LinkedHashMap<>();

        EnumSet.allOf(Coin.class)
                .forEach(coin -> this.coins.put(coin, MIN_COUNT));
    }

    public void chargeCoin(Coin coin, int count) {
        if (count == 0) {
            return;
        }

        coins.put(coin, count + coins.get(coin));
    }

    public int amount(Coin coin) {
        return coin.carculateAmount(coins.get(coin));
    }

    public int totalAmount() {
        return EnumSet.allOf(Coin.class).stream()
                .mapToInt((coin) -> coin.carculateAmount(coins.get(coin))).sum();
    }
}
