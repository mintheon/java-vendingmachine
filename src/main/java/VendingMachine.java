import model.Items;
import model.VendingService;
import view.Input;

public class VendingMachine {
    private static final Input input = new Input();

    VendingMachine() {
    }

    public void on() {
        int coin = input.setCoin();
        Items items = new Items(input.chargeItems());

        VendingService vendingService = new VendingService();
    }
}
