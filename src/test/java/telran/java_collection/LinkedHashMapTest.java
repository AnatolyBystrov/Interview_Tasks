package telran.java_collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedHashMapTest {
    String[] strings = {"abc", "lmn", "ddd", "hhh"};
    Integer[] numbers = {10, 5, 13, 20};
    LinkedHashMap<String, Integer> map;

    @BeforeEach
    void setUp() throws Exception {
        map = new LinkedHashMap<String, Integer>(16, 0.75f, true)
        {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> entry)
            {
                return size() > strings.length;
            }};
        IntStream.range(0,strings.length).forEach(i-> map.put(strings[i], numbers[i]));
    }

    @Test
    void putOrdertest()
    {
        assertArrayEquals(numbers, map.values().toArray(Integer[]:: new));
        map.put("ttt", 100);
        Integer[] expected = { 5, 13, 20, 100};
        assertArrayEquals(expected, map.values().toArray(Integer[]:: new));
    }

    @Test
    void getOrdertest()
    {
        assertArrayEquals(numbers, map.values().toArray(Integer[]:: new));
        assertEquals(10,map.get("abc"));
        map.put("ttt", 100);
        Integer[] expected = {13, 20, 10, 100};
        assertArrayEquals(expected, map.values().toArray(Integer[]:: new));
    }

}