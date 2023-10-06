package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String letters, String word) {
        List<Character> lettersList = new ArrayList<>();

        for (char c : letters.toLowerCase().toCharArray()) {
            lettersList.add(c);
        }

        List<Character> wordList = new ArrayList<>();
        for (char c : word.toLowerCase().toCharArray()) {
            wordList.add(c);
        }

        for (char c : wordList) {
            if (!lettersList.contains(Character.valueOf(c))) {
                return false;
            }
            lettersList.remove(Character.valueOf(c));
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(scrabble("rkqodlw", "world")); // true
        System.out.println(scrabble("ajv", "java")); // false
        System.out.println(scrabble("avjafff", "JaVa")); // true
        System.out.println(scrabble("", "hexlet")); // false
    }
}
//END
