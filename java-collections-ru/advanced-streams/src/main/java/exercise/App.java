package exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static String getForwardedVariables(String configFileContent) {
        Map<String, String> variables = new HashMap<>();
        Arrays.stream(configFileContent.split(","))
                .filter(s -> s.startsWith("X_FORWARDED_"))
                .map(s -> s.split("="))
                .forEach(entry -> variables.put(entry[0].replace("X_FORWARDED_", ""), entry[1]));

        return variables.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining(","));
    }
}