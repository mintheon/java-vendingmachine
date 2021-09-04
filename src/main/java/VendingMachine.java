import model.Items;
import view.Input;

public class VendingMachine {
    private static final Input input = new Input();

    VendingMachine() {
    }

    public void on() {
        int coin = input.setCoin();
        Items items = new Items(input.chargeItems());
        int amountOfMoney = input.putMoney();
    }
}
