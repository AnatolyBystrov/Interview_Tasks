package telran.java_collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



public class StandardSetTest {

    Integer[] numbers = {10, 13, 14, 5, 10, 5, 11, 13, 5};
    TreeSet<Integer> treeSet;
    @BeforeEach
    void setUp()
    {
        treeSet = new TreeSet<>(List.of(numbers));
    }
    @Test
    void distinctListTest()
    {
        Integer[] expected = {10, 13, 14, 5, 11};
        Integer[] actual =  distinctList(List.of(numbers)).toArray(Integer[]::new);
        assertArrayEquals(expected, actual);
    }

    List<Integer> distinctList(List<Integer> listWithRepeated)
    {
        return new ArrayList<>(new LinkedHashSet(listWithRepeated));
    }
    @Test
    void treeSetTest()
    {
        Integer[]expected = {5, 10,11,13,14};
        Integer[]actual = treeSet.toArray(Integer[]::new);
        assertArrayEquals(expected, actual);
    }
    @Test
    void treeSubsetTest()
    {
        NavigableSet<Integer> subset10_13 = treeSet.subSet(10, true, 13, true);
        Integer[] expected = {10,11,13};
        Integer[]actual = subset10_13.toArray(Integer[]::new);
        assertArrayEquals(expected, actual);
        subset10_13.add(12);
        Integer[] expected1 = {5,10,11,12,13,14};
        Integer[] actualAll = treeSet.toArray(Integer[]::new);
        assertArrayEquals(expected1, actualAll);
        Integer[] expected2 = {5,14};
        subset10_13.clear();
        actualAll = treeSet.toArray(Integer[]::new);
        assertArrayEquals(expected2, actualAll);
        assertThrows(IllegalArgumentException.class,() -> subset10_13.add(14));
        assertThrows(IllegalArgumentException.class,() -> subset10_13.add(9));
    }

}
