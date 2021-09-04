package enums;

public enum ErrorCode implements EnumModel {
    NOT_NUMBER("ERROR", "숫자가 아닙니다. 다시 입력해주세요."),
    EMPTY("ERROR", "아무 값도 입력하지 않았습니다. 다시 입력해주세요.");

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
