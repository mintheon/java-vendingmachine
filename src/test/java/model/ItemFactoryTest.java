package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemFactoryTest {
    final ItemFactory itemFactory = new ItemFactory();

    @Test
    @DisplayName("아이템 목록 생성 확인")
    void generateItems() {
//        String[] itemsInfo = {"[콜라,20,1500]", "[사이다,10,1000]"};
//
//        Map<Item, Integer> itemsInfoMap = new HashMap<>();
//        itemsInfoMap.put(new Item("사이다", 1000), 10);
//        itemsInfoMap.put(new Item("콜라", 1500), 20);
//
//        try {
//            assertEquals(itemFactory.generateItems(itemsInfo), itemsInfoMap);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        String[] wrongQtItemsInfo = {"[콜라,0,1500]", "[사이다,10,1000]"};
        assertThrows(IllegalArgumentException.class, () -> itemFactory.generateItems(wrongQtItemsInfo));
    }

    @Test
    @DisplayName("입력 텍스트의 대괄호 제거 확인")
    void removeBrackets() {
        String[] itemsInfo = {"[콜라,20,1500]", "[사이다,10,1000]"};

        List<String> itemInfoList = new ArrayList<>();
        itemInfoList.add("콜라,20,1500");
        itemInfoList.add("사이다,10,1000");

        assertEquals(itemFactory.removeBrackets(itemsInfo), itemInfoList);
    }

    @Test
    @DisplayName("입력 텍스트의 구성 개수 확인")
    void isCorrectCompositionCount() {
        String[] itemInfo = {"콜라", "20", "1500"};
        assertEquals(itemFactory.isCorrectCompositionCount(itemInfo), true);

        String[] wrongLengthItemInfo = {"콜라", "20"};
        assertEquals(itemFactory.isCorrectCompositionCount(wrongLengthItemInfo), false);
    }

    @Test
    @DisplayName("물품 생성 여부")
    void generateItem() {
        String[] itemInfo = {"콜라", "20", "1500"};
        try {
            assertEquals(itemFactory.generateItem(itemInfo), new Item("콜라", 1500));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 이름이 비어있음
        String[] emptyNameItemInfo = {"", "10", "1500"};
        assertThrows(IllegalArgumentException.class, () -> itemFactory.generateItem(emptyNameItemInfo));

        // 가격이 유효하지 않음
        String[] wrongPriceItemInfo = {"사이다", "10", "0"};
        assertThrows(IllegalArgumentException.class, () -> itemFactory.generateItem(wrongPriceItemInfo));
    }

    @Test
    @DisplayName("물품 가격 범위 확인")
    void isCorrectPrice() {
        // 물품 가격이 10으로 나누어지는 여부
        assertAll(
                () -> assertEquals(itemFactory.isCorrectPrice(101), false),
                () -> assertEquals(itemFactory.isCorrectPrice(310), true)
        );


        // 최소값 범위 만족 여부
        assertAll(
                () -> assertEquals(itemFactory.isCorrectPrice(90), false),
                () -> assertEquals(itemFactory.isCorrectPrice(100), true)
        );
    }

    @Test
    @DisplayName("물품 수량 범위 확인")
    void isCorrectQt() {
        assertAll(
                () -> assertEquals(itemFactory.isCorrectQt(0), false),
                () -> assertEquals(itemFactory.isCorrectPrice(300), true)
        );
    }
}