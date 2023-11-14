package exercise;

import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

// BEGIN
public class Sorter {

    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return users.stream()
                .filter(user -> user.get("gender").equals("male"))
                .sorted(comparing(user -> LocalDate.parse(user.get("birthday"), formatter)))
                .map(user -> user.get("name"))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Map<String, String> user1 = Map.of(
                "name", "Andrey Belov",
                "birthday", "1980-11-23",
                "gender", "male"
        );
        Map<String, String> user2 = Map.of(
                "name", "John Doe",
                "birthday", "1972-05-15",
                "gender", "male"
        );
        Map<String, String> user3 = Map.of(
                "name", "Anna Smith",
                "birthday", "1995-08-30",
                "gender", "female"
        );

        List<Map<String, String>> users = List.of(user1, user2, user3);

        System.out.println(takeOldestMans(users)); // [John Doe, Andrey Belov]
    }
}
// END
