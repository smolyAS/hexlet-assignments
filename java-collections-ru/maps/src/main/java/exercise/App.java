package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> wordCount = new HashMap<>();

        if (sentence.isEmpty()) {
            return wordCount;
        }

        String[] words = sentence.split(" ");

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }

    public static String toString(Map<String, Integer> wordCount) {

        if (wordCount.isEmpty()) {
            return "{}";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (Entry entry : wordCount.entrySet()) {
            sb.append(" ")
                    .append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append("\n");
        }

        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        String sentence = "the java is the best programming language java";
        Map wordsCount = App.getWordCount(sentence);
        String result = App.toString(wordsCount);
        System.out.println(result);


        Map wordsCount2 = App.getWordCount("");
        String result2 = App.toString(wordsCount2);
        System.out.println(result2);
    }
}
//END
