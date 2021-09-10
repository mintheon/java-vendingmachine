package model;

import enums.ErrorCode;

import java.util.Map;

public class Items {
    private final Map<Item, Integer> items;

    public Items(Map<Item, Integer> items) {
        this.items = items;
    }

    public Item comeOut(String itemName) {
        Item item = getItem(itemName);

        if (!isExist(item)) {
            throw new IllegalArgumentException(ErrorCode.NOT_EXIST_ITEM.getValue());
        }

        items.put(item, items.get(item) - 1);

        return item;
    }

    public Item getItem(String itemName) {
        return items.keySet().stream()
                .filter((item) -> item.isSameName(itemName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorCode.NOT_EXIST_ITEM.getValue()));
    }

    private boolean isExist(Item item) {
        return items.containsKey(item);
    }

    public int minPrice() {
        return items.keySet().stream()
                .map(Item::getPrice)
                .min(Integer::compareTo)
                .orElse(0);
    }
}
