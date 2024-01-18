package exercise;

import java.util.ArrayList;
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

    public static void main(String[] args) {
        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));

        List<String> result = App.buildApartmentsList(apartments, 3);
        System.out.println(result);
    }
}
