package enums;

public enum ErrorCode {
    NOT_NUMBER("숫자가 아닙니다."),
    WRONG_FORMAT("입력 포맷에 맞지 않습니다. 입력 포맷은 '[물품명,개수,가격];[물품명,개수,가격];..' 입니다."),
    EMPTY("입력 값이 비어있습니다."),
    WRONG_PRICE("상품의 최소 금액은 100원이며, 10원으로 나누어 떨어져야합니다."),
    NOT_ZERO("1 이상의 숫자를 입력해주세요."),
    NOT_EXIST_ITEM("존재하지 않는 상품입니다.");

    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }
}
