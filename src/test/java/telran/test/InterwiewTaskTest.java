package telran.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.interviews.*;

import static org.junit.jupiter.api.Assertions.*;

class InterviewTaskTest {

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void myArrayTest() {
        MyArray<String> newArray = new MyArray(5);
        newArray.addElement("Max");
        newArray.addElement("Mark");
        newArray.addElement("Ira");
        assertTrue(newArray.get(1).equals("Mark"));
        newArray.set(1, "Gena");
        assertTrue(newArray.get(1).equals("Gena"));
        newArray.setAll("Ura");
        assertTrue(newArray.get(0).equals("Ura"));
        assertThrows(IndexOutOfBoundsException.class, () -> newArray.get(6));

    }

    String word = "yellow";

    @Test
    void testAnagramTrue() {
        assertTrue(Anagram.isAnagram(word, "loweyl"));
        assertTrue(Anagram.isAnagram(word, "elolyw"));
        assertTrue(Anagram.isAnagram(word, "wolley"));
        assertTrue(Anagram.isAnagram(word, "loleyw"));

    }

    @Test
    void testAnagramFalse() {
        assertFalse(Anagram.isAnagram(word, ""));
        assertFalse(Anagram.isAnagram(word, "yellob"));
        assertFalse(Anagram.isAnagram(word, "yello"));
        assertFalse(Anagram.isAnagram(word, "yelllo"));
    }

    @Test
    void testAnagram2True() {
        assertTrue(Anagram.isAnagramVarianTwo(word, "loweyl"));
        assertTrue(Anagram.isAnagramVarianTwo(word, "elolyw"));
        assertTrue(Anagram.isAnagramVarianTwo(word, "wolley"));
        assertTrue(Anagram.isAnagramVarianTwo(word, "loleyw"));

    }

    @Test
    void testAnagram2False() {
        assertFalse(Anagram.isAnagramVarianTwo(word, ""));
        assertFalse(Anagram.isAnagramVarianTwo(word, "yellob"));
        assertFalse(Anagram.isAnagramVarianTwo(word, "yello"));
        assertFalse(Anagram.isAnagramVarianTwo(word, "yelllo"));

    }



    @Test
    void ConnectionTest() {

        ConnectionsPool pool = new ConnectionsPoolImpl(3);
        pool.addConnection(new Connection(11111, "Max", 1));
        pool.addConnection(new Connection(22222, "Mark", 2));
        pool.addConnection(new Connection(33333, "Gena", 3));
        assertFalse(pool.addConnection(new Connection(33333, "Gena", 3)));
        assertTrue(pool.addConnection(new Connection(66666, "Ira", 6)));
        assertEquals(22222, pool.getConnection(22222).id);
        assertTrue(pool.addConnection(new Connection(99999, "Ura", 9)));



    }
};