import model.Items;
import model.VendingService;
import view.Input;

public class VendingMachine {
    private static final Input input = new Input();

    VendingMachine() {
    }

    public void on() {
        int amountOfCoin = input.setCoin();
        Items items = new Items(input.chargeItems());
        int amountOfMoney = input.putMoney();

        VendingService vendingService = new VendingService(amountOfCoin, items, amountOfMoney);
        vendingService.start();
    }
}
