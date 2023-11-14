package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        List<String> freeEmailDomains = Arrays.asList("gmail.com", "yandex.ru", "hotmail.com");
        return emails.stream()
                .map(email -> email.split("@"))
                .filter(parts -> parts.length == 2)
                .filter(parts -> freeEmailDomains.contains(parts[1]))
                .count();
    }

    public static void main(String[] args) {
        String[] emails = {
                "info@gmail.com",
                "info@yandex.ru",
                "mk@host.com",
                "support@hexlet.io",
                "info@hotmail.com",
                "support.yandex.ru@host.com"
        };
        List<String> emailsList = Arrays.asList(emails);
        System.out.println(getCountOfFreeEmails(emailsList)); // 3
    }
}
// END
