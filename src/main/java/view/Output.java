package view;

public class Output {
    private static final String MACHINE_SET_COIN = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String ITEM_QT_PRICE = "상품명과 수량, 금액을 입력해 주세요.";
    private static final String INPUT_PRICE = "투입 금액을 입력해 주세요.";
    private static final String BUY_ITEM = "구매할 상품명을 입력해 주세요.";

    public static void setBuyItem() {
        System.out.println(BUY_ITEM);
    }

    public static void setMachineCoin() {
        System.out.println(MACHINE_SET_COIN);
    }

    public static void setItems() {
        System.out.println(ITEM_QT_PRICE);
    }

    public static void setInputPrice() {
        System.out.println(INPUT_PRICE);
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
