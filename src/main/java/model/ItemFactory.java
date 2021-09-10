package model;

import enums.ErrorCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ItemFactory {
    private static final String ITEM_COMPOSITION_SEPARATOR = ",";

    public ItemFactory() {
    }

    public Map<Item, Integer> generateItems(String[] itemsInfo) throws Exception {
        Map<Item, Integer> items = new HashMap<>();
        List<String> removedBracketItemsInfo = removeBrackets(itemsInfo);

        for (String itemInfo : removedBracketItemsInfo) {
            String[] itemComposition = itemInfo.split(ITEM_COMPOSITION_SEPARATOR);

            if (!isCorrectCompositionCount(itemComposition)) {
                throw new IllegalArgumentException(ErrorCode.WRONG_FORMAT.getValue());
            }

            int qt = Integer.parseInt(itemComposition[1]);
            if (!isCorrectQt(qt)) {
                throw new IllegalArgumentException(ErrorCode.NOT_ZERO.getValue());
            }

            items.put(generateItem(itemComposition), qt);
        }

        return items;
    }

    public List<String> removeBrackets(String[] itemsText) {
        return Arrays.stream(itemsText)
                .map(itemText ->
                        itemText.replace("[", "")
                                .replace("]", ""))
                .collect(Collectors.toList());
    }

    public boolean isCorrectCompositionCount(String[] itemComposition) {
        return itemComposition.length == 3;
    }

    public Item generateItem(String[] itemComposition) throws Exception {
        String name = itemComposition[0];
        int price = Integer.parseInt(itemComposition[2]);

        if (name.isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.EMPTY.getValue());
        }

        if (!isCorrectPrice(price)) {
            throw new IllegalArgumentException(ErrorCode.WRONG_PRICE.getValue());
        }

        return new Item(name, price);
    }

    public boolean isCorrectPrice(int price) {
        return price >= 100 || price % 10 != 0;
    }

    public boolean isCorrectQt(int qt) {
        return qt > 0;
    }

}
