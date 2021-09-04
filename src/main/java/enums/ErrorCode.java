package enums;

public enum ErrorCode implements EnumModel {
    NOT_NUMBER("ERROR", "숫자가 아닙니다. 다시 입력해주세요."),
    WRONG_FORMAT("ERROR", "입력 포맷에 맞지 않습니다. 입력 포맷은 '[물품명,개수,가격];[물품명,개수,가격];..' 입니다."),
    EMPTY("ERROR", "입력 값이 비어있습니다. 다시 입력해주세요.");

    private String key;
    private String message;

    ErrorCode(String key, String message) {
        this.key = key;
        this.message = message;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return message;
    }
}
