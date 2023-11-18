package exercise;

import java.util.*;

// BEGIN
public class App {

    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> result = new LinkedHashMap<>();

        // Получаем все уникальные ключи из обоих словарей
        Set<String> allKeys = new TreeSet<>(data1.keySet());
        allKeys.addAll(data2.keySet());

        // Итерируемся по всем ключам
        for (String key : allKeys) {
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (value1 == null) {
                // Ключ отсутствует в первом словаре, добавлен во втором
                result.put(key, "added");
            } else if (value2 == null) {
                // Ключ отсутствует во втором словаре, был в первом
                result.put(key, "deleted");
            } else if (value1.equals(value2)) {
                // Значения ключа идентичны в обоих словарях
                result.put(key, "unchanged");
            } else {
                // Значения ключа отличаются в обоих словарях
                result.put(key, "changed");
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Map<String, Object> data1 = new HashMap<>(
                Map.of("one", "eon", "two", "two", "four", true)
        );
        System.out.println(data1); //=> {two=two, four=true, one=eon}

        Map<String, Object> data2 = new HashMap<>(
                Map.of("two", "own", "zero", 4, "four", true)
        );
        System.out.println(data2); //=> {zero=4, two=own, four=true}

        Map<String, String> result = App.genDiff(data1, data2);
        System.out.println(result); //=> {four=unchanged, one=deleted, two=changed, zero=added}
    }
}
//END
