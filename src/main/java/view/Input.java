package view;


import java.util.InputMismatchException;

public class Input implements InputInterface {
    private static final Output output = new Output();

    public Input() {
    }

    public int setCoin() {
        while (true) {
            try {
                output.machineSetCoin();
                int coin = scanner.nextInt();

                return coin;
            } catch (InputMismatchException e) {
                output.notNumber();
                bufferClear();
                continue;
            }
        }
    }

    public void bufferClear() {
        scanner.nextLine();
    }
}
