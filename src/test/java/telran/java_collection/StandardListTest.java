package telran.java_collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StandardListTest {

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void test() {
        List<Integer> list = List.of(10, -5, 12, 13, 17, 10);
        assertThrows(UnsupportedOperationException.class, () -> list.remove(0));
        LinkedList<Integer> linkedList = new LinkedList<>(list);
        linkedList.remove(0);
        Integer[] expected = { -5, 12, 13, 17, 10 };
        assertArrayEquals(expected, linkedList.toArray(Integer[]::new));

    }

    @Test
    void sublistTest() {
        LinkedList<Integer> linkedList = new LinkedList<>(List.of(10, -5, 12, 13, 17, 10));
        List<Integer> sublist1 = linkedList.subList(1, 3);
        Integer[] expected = { -5, 12 };
        Integer[] expected2 = { 10, -5, 100, 12, 13, 17, 10 };
        sublist1.add(1, 100);
        assertArrayEquals(expected2, linkedList.toArray(Integer[]::new));
        List<Integer> sublist2 = linkedList.subList(5, linkedList.size());
        Integer[] expected3 = { 17, 10 };
        assertArrayEquals(expected3, sublist2.toArray(Integer[]::new));
        sublist2.remove(0);
        Integer[] expected4 = { 10, -5, 100, 12, 13, 10 };
        Integer[] expected5 = { 10 };
        assertArrayEquals(expected5, sublist2.toArray(Integer[]::new));
        assertThrows(ConcurrentModificationException.class, () -> sublist1.toArray(Integer[]::new));
        linkedList.add(10);
        assertThrows(ConcurrentModificationException.class, () -> sublist2.toArray(Integer[]::new));
    }

}