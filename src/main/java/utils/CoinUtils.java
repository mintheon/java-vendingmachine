package utils;

import enums.Coin;

public class CoinUtils {

    //CHECKME: 완전히 랜덤을 돌리기 때문에 해당 동전들이 딱 입력금액에 맞지 않는 경우가 생김 -> 어떻게 처리할것인가?
    public int generateRandomCoinCount(Coin coin, int chargeAmount) {
        if (chargeAmount <= 0) {
            return 0;
        }

        int maxCount = coin.maxCount(chargeAmount);

        return (int) (Math.random() * maxCount);
    }
}
