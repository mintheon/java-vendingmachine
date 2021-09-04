package view;


import enums.ErrorCode;
import model.Item;
import model.ItemFactory;

import java.util.InputMismatchException;
import java.util.List;

public class Input implements InputInterface {
    private static final String ITEM_SEPARATOR = ";";

    private static final Output output = new Output();

    public Input() {
    }

    public int setCoin() {
        while (true) {
            try {
                output.setMachineCoin();
                int coin = scanner.nextInt();

                return coin;
            } catch (InputMismatchException e) {
                output.errorPrint(ErrorCode.NOT_NUMBER.getValue());
                continue;
            } finally {
                bufferClear();
            }
        }
    }

    public List<Item> chargeItems() {
        ItemFactory itemFactory = new ItemFactory();

        while (true) {
            try {
                output.setItems();

                String[] itemsInfo = scanner.nextLine()
                        .split(ITEM_SEPARATOR);

                if (!isCorrectFormat(itemsInfo)) {
                    throw new IllegalArgumentException(ErrorCode.WRONG_FORMAT.getValue());
                }

                return itemFactory.generateItems(itemsInfo);
            } catch (NumberFormatException e) {
                output.errorPrint(ErrorCode.NOT_NUMBER.getValue());
                continue;
            } catch (IllegalArgumentException e) {
                output.errorPrint(e.getMessage());
                continue;
            } catch (Exception e) {
                output.errorPrint(e.getMessage());
                continue;
            }
        }
    }

    private boolean isCorrectFormat(String[] itemsText) {
        for (String itemText : itemsText) {
            int lastIndex = itemText.length() - 1;

            if (!(itemText.charAt(0) == '[' && itemText.charAt(lastIndex) == ']')) {
                return false;
            }
        }

        return true;
    }

    public void bufferClear() {
        scanner.nextLine();
    }
}
