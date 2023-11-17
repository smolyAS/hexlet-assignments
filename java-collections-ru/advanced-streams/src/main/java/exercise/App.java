package exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static String getForwardedVariables(String configFile) {
        Map<String, String> variables = new HashMap<>();

        String environmentLine = Arrays.stream(configFile.split("\\n"))
                .filter(line -> line.startsWith("environment="))
                .findFirst()
                .orElse("");

        String[] environmentVariables = environmentLine.replaceAll("^environment=\"|\"$", "").split(",");

        Arrays.stream(environmentVariables)
                .filter(variable -> variable.startsWith("X_FORWARDED_"))
                .forEach(variable -> {
                    String name = variable.substring("X_FORWARDED_".length());
                    String[] parts = name.split("=");
                    if (parts.length == 2) {
                        String key = parts[0];
                        String value = parts[1];
                        variables.put(key, value.replace("\"", ""));
                    }
                });

        return variables.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining(","));
    }
}