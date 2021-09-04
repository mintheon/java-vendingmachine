import model.Machine;
import view.Input;

public class VendingMachine {
    private static final Input input = new Input();

    VendingMachine() {
    }

    public void on() {
        int coin = input.setCoin();

        Machine machine = new Machine();
    }
}
