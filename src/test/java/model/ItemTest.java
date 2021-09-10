package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ItemTest {
    Item item;

    @BeforeAll
    void init() {
        item = new Item("사과", 1000);
    }

    @Test
    @DisplayName("물품의 가격 확인")
    void getPrice() {
        assertEquals(item.getPrice(), 1000);
    }

    @Test
    @DisplayName("물품의 이름 동일여부 확인")
    void isSameName() {
        assertEquals(item.isSameName("사과"), true);
    }
}