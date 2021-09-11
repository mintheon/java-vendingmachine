package domain;

import enums.Coin;
import utils.RandomCoinUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CoinBox {
    private static final int MIN_COUNT = 0;

    private final Map<Coin, Integer> coinBox;

    public CoinBox(List<Coin> coins) {
        this(
                coins.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.reducing(0, e -> 1, Integer::sum)))
        );
    }

    public CoinBox(final Map<Coin, Integer> coins) {
        this.coinBox = coins;
    }

    public static CoinBox charge(int chargeAmount) {
        final List<Coin> coins = new ArrayList<>();

        while (chargeAmount > 0) {
            final Coin coin = RandomCoinUtils.randomCoinPick();

            if (chargeAmount - coin.getAmount() < 0) {
                continue;
            }

            chargeAmount -= coin.getAmount();
            coins.add(coin);
        }

        return new CoinBox(coins);
    }

    public int total() {
        return coinBox.entrySet().stream()
                .mapToInt(e -> e.getKey().getAmount() * e.getValue())
                .sum();
    }
}
