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

    @Override
    public boolean equals(Object target) {
        if (this == target) {
            return true;
        }

        if (target == null || getClass() != target.getClass()) {
            return false;
        }

        Item item = (Item) target;
        return name.equals(item.name) && price == item.price;
    }
}
