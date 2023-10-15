package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {

    public static Map getWordCount(String sentence) {
        Map wordCount = new HashMap<>();

        String[] words = sentence.split(" ");
        for (String word : words) {
            wordCount.put(word, (int) wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }

    public static String toString(Map wordCount) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        wordCount.forEach((key, value) -> sb.append("  " + key + ": " + value + "\n"));
        sb.append("}");

        return sb.toString();
    }

    public static void main(String[] args) {
        String sentence = "the java is the best programming language java";
        Map wordsCount = App.getWordCount(sentence);
        String result = App.toString(wordsCount);
        System.out.println(result);
    }
}
//END
