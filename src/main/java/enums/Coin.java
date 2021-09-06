package enums;

public enum Coin {
    FIVE_HUNDRED(500, "500원"),
    ONE_HUNDRED(100, "100원"),
    FIFTY(50, "50원"),
    TEN(10, "10원");

    private int amount;
    private String name;

    Coin(int amount, String name) {
        this.amount = amount;
        this.name = name;
    }

    public int maxCount(int amountOfCoin) {
        return amountOfCoin / amount;
    }

    public int carculateAmount(int countOfCoin) {
        return amount * countOfCoin;
    }
}
