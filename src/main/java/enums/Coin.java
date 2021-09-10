package enums;

public enum Coin {
    FIVE_HUNDRED(500),
    ONE_HUNDRED(100),
    FIFTY(50),
    TEN(10);

    private int amount;

    Coin(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int maxCount(int amountOfCoin) {
        return amountOfCoin / amount;
    }

    public int carculateAmount(int countOfCoin) {
        return amount * countOfCoin;
    }
}
