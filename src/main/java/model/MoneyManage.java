package model;

import view.Output;

public class MoneyManage {
    private Coins coins;
    private int inputMoney;

    public MoneyManage() {
    }

    public void chargeCoins(Coins coins) {
        this.coins = coins;
    }

    public void inputMoney(int amountOfMoney) {
        this.inputMoney = amountOfMoney;
    }

    public boolean isPossibleBuy(int price) {
        return price <= inputMoney;
    }

    public void printMoney() {
        Output.print("남은 금액: " + inputMoney + "원");
    }

    public void printCoins() {
        coins.smallChange(inputMoney);
    }

    public void buyItem(Item item) {
        int price = item.getPrice();

        inputMoney -= price;
    }
}
