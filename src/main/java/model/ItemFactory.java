package model;

import enums.ErrorCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ItemFactory {
    private static final String ITEM_COMPOSITION_SEPARATOR = ",";

    public ItemFactory() {
    }

    public List<Item> generateItems(String[] itemsInfo) throws Exception {
        List<Item> items = new ArrayList<>();
        List<String> removedBracketItemsInfo = removeBrackets(itemsInfo);

        for (String itemInfo : removedBracketItemsInfo) {
            String[] itemComposition = itemInfo.split(ITEM_COMPOSITION_SEPARATOR);

            if (!isCorrectCompositionCount(itemComposition)) {
                throw new IllegalArgumentException(ErrorCode.WRONG_FORMAT.getValue());
            }

            items.add(generateItem(itemComposition));
        }

        return items;
    }

    private List<String> removeBrackets(String[] itemsText) {
        return Arrays.stream(itemsText)
                .map(itemText ->
                        itemText.replace("[", "")
                                .replace("]", ""))
                .collect(Collectors.toList());
    }

    private boolean isCorrectCompositionCount(String[] itemComposition) {
        return itemComposition.length == 3;
    }

    private Item generateItem(String[] itemComposition) throws Exception {
        if (itemComposition[0].isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.EMPTY.getValue());
        }

        return new Item(itemComposition[0],
                Integer.parseInt(itemComposition[1]),
                Integer.parseInt(itemComposition[2]));
    }

}
