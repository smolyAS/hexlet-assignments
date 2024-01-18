package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int n) {
        // Сортировка объектов по площади по возрастанию
        List<Home> sortedHomes = homes.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .collect(Collectors.toList());

        // Получение первых n элементов
        List<Home> selectedHomes = sortedHomes.stream()
                .limit(n)
                .collect(Collectors.toList());

        // Преобразование выбранных объектов в строковые представления
        List<String> result = selectedHomes.stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        return result;
    }
}
