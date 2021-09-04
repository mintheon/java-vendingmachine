package view;

public class Output {
    private static final String MACHINE_SET_COIN = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String ITEM_QT_PRICE = "상품명과 수량, 금액을 입력해 주세요.";
    private static final String INPUT_PRICE = "투입 금액을 입력해 주세요.";
    private static final String BUY_ITEM = "구매할 상품명을 입력해 주세요.";

    public void setMachineCoin() {
        System.out.println(MACHINE_SET_COIN);
    }

    public void setItems() {
        System.out.println(ITEM_QT_PRICE);
    }

    public void setInputPrice() {
        System.out.println(INPUT_PRICE);
    }

    public void errorPrint(String message) {
        System.out.println(message);
    }
}
