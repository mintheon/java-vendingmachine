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

    public void charge(Coin coin, int count) {
        if (count == MIN_COUNT) {
            return;
        }

        coins.put(coin, count + coins.get(coin));
    }

    public int amount(Coin coin) {
        return coin.carculateAmount(coins.get(coin));
    }

    public int totalAmount() {
        return coins.keySet().stream()
                .mapToInt((coin) -> coin.carculateAmount(coins.get(coin)))
                .sum();
    }

    public void smallChange(int inputMoney) {
        int remainAmount = inputMoney;

        System.out.println("잔돈");

        for (Coin coin : coins.keySet()) {
            if (remainAmount == MIN_COUNT) {
                return;
            }

            int count = carculateCount(coin, remainAmount);
            if (count == MIN_COUNT) {
                continue;
            }

            System.out.println(coin.getAmount() + "원 - " + count + "개");

            remainAmount -= coin.carculateAmount(count);
        }
    }

    private int carculateCount(Coin coin, int remainAmount) {
        int maxCount = coin.maxCount(remainAmount);

        if (coins.get(coin) < maxCount) {
            return coins.get(coin);
        }

        return maxCount;
    }
}
