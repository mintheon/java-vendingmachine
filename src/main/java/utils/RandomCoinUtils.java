package utils;

import com.woowahan.techcourse.utils.Randoms;
import enums.Coin;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class RandomCoinUtils {

    public static Coin randomCoinPick() {
        List<Coin> coins = new ArrayList<Coin>(EnumSet.allOf(Coin.class));

        return coins.get(Randoms.pick(0, coins.size() - 1));
    }
}
