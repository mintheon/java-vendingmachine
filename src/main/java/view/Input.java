package view;

import enums.ErrorCode;
import model.Item;
import model.ItemFactory;

import java.util.InputMismatchException;
import java.util.Map;

//CHECKME: Input로직과 도메인 로직을 완전히 분리해보려 했으나 쉽지 않음..
// 결국 모델에도 있고, 여기에도 있고 하는 방식으로 혼재되게 되었는데 해당 부분을 어떻게 처리할지 정말 고민입니다.
// 관련 모델에 입력 로직과 validate 하는 로직을 두는게 맞는건지..?
public class Input implements InputInterface {
    private static final String ITEM_SEPARATOR = ";";

    public Input() {
    }

    public static String setBuyItem() {
        Output.setBuyItem();

        return scanner.nextLine();
    }

    public int setCoin() {
        while (true) {
            try {
                Output.setMachineCoin();

                return scanner.nextInt();
            } catch (InputMismatchException e) {
                Output.print(ErrorCode.NOT_NUMBER.getValue());
                continue;
            } catch (Exception e) {
                Output.print(e.getMessage());
                continue;
            } finally {
                bufferClear();
            }
        }
    }

    public void bufferClear() {
        scanner.nextLine();
    }

    public Map<Item, Integer> chargeItems() {
        ItemFactory itemFactory = new ItemFactory();

        while (true) {
            try {
                Output.setItems();

                String[] itemsInfo = scanner.nextLine()
                        .split(ITEM_SEPARATOR);

                if (!isCorrectFormat(itemsInfo)) {
                    throw new IllegalArgumentException(ErrorCode.WRONG_FORMAT.getValue());
                }

                return itemFactory.generateItems(itemsInfo);
            } catch (NumberFormatException e) {
                Output.print(ErrorCode.NOT_NUMBER.getValue());
                continue;
            } catch (Exception e) {
                Output.print(e.getMessage());
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

    public int putMoney() {
        while (true) {
            try {
                Output.setInputPrice();

                return scanner.nextInt();
            } catch (InputMismatchException e) {
                Output.print(ErrorCode.NOT_NUMBER.getValue());
                continue;
            } catch (Exception e) {
                Output.print(e.getMessage());
                continue;
            } finally {
                bufferClear();
            }
        }
    }
}
