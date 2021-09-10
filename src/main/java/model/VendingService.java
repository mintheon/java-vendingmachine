package model;

import enums.Coin;
import utils.CoinUtils;
import view.Input;
import view.Output;

import java.util.EnumSet;

public class VendingService {
    private final CoinUtils coinUtils = new CoinUtils();

    private MoneyManage moneyManage;
    private Items items;

    public VendingService(int amountOfCoin, Items items, int amountOfMoney) {
        moneyManage = new MoneyManage();

        chargeCoins(amountOfCoin);
        chargeItems(items);
        putMoney(amountOfMoney);
    }

    public void chargeCoins(int amountOfCoin) {
        Coins coins = new Coins();

        int amount = amountOfCoin;

        while (amount > 0) {
            for (Coin coin : EnumSet.allOf(Coin.class)) {
                int randomCount = coinUtils.generateRandomCoinCount(coin, amount);

                coins.charge(coin, randomCount);
                amount -= coin.carculateAmount(randomCount);
            }
        }

        moneyManage.chargeCoins(coins);
    }

    public void chargeItems(Items items) {
        this.items = items;
    }

    public void putMoney(int amountOfMoney) {
        moneyManage.inputMoney(amountOfMoney);
    }

    public void start() {
        while (isContinueBuy()) {
            moneyManage.printMoney();

            purchaseItem(Input.setBuyItem());
        }

        moneyManage.printMoney();
        moneyManage.printCoins();
    }

    private void purchaseItem(String itemName) {
        try {
            Item item = items.comeOut(itemName);
            moneyManage.buyItem(item);

        } catch (Exception e) {
            Output.print(e.getMessage());
        }
    }

    private boolean isContinueBuy() {
        return moneyManage.isPossibleBuy(items.minPrice());
    }
}
