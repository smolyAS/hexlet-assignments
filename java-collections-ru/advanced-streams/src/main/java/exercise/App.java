package exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static String getForwardedVariables(String configFile) {
        Map<String, String> variables = new HashMap<>();

        String[] lines = configFile.split("\n");

        for (String line : lines) {
            if (line.startsWith("environment=")) {
                String[] environmentVariables = line.replaceAll("^environment=", "").replaceAll("$", "").split(",");

                for (String variable : environmentVariables) {
                    if (variable.startsWith("X_FORWARDED_")) {
                        String name = variable.substring("X_FORWARDED_".length());
                        String[] parts = name.split("=");

                        if (parts.length == 2) {
                            String key = parts[0];
                            String value = parts[1];
                            variables.put(key, value.replace("\"", ""));
                        }
                    }
                }

                break;
            }
        }

        return variables.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining(","));
    }
}