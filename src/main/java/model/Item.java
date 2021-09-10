package model;

public class Item {
    private String name;
    private int price;

    Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public boolean isSameName(String targetName) {
        return name.equals(targetName);
    }
}
