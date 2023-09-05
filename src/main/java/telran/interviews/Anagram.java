package telran.interviews;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static boolean isAnagram(String str, String anagram) {
        boolean res = false;
        if (str.length() == anagram.length()) {
            char[] word = str.toCharArray();
            char[] anag = anagram.toCharArray();
            Arrays.sort(word);
            Arrays.sort(anag);
            res = Arrays.equals(word, anag);}
        return res;

    }

    public static boolean isAnagramVarianTwo(String str, String anagram) {
        if (str.length() != anagram.length()) {
            return false;
        }
        Map<Character, Integer> mapForCouting = new HashMap<>();

        for (char letter : str.toCharArray()) {
            mapForCouting.put(letter, mapForCouting.getOrDefault(letter, 0) + 1);
        }

        for (char letter : anagram.toCharArray()) {

            if (!mapForCouting.containsKey(letter)) {
                return false;
            }
            mapForCouting.put(letter, mapForCouting.get(letter) - 1);

            if (mapForCouting.get(letter) == 0) {
                mapForCouting.remove(letter);
            }
        }

        return mapForCouting.isEmpty();

    }

}