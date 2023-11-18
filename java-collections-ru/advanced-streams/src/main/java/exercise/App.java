package exercise;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static String getForwardedVariables(String configFile) {
        String environmentLine = Arrays.stream(configFile.split("\n"))
                .filter(line -> line.contains("environment"))
                .findFirst()
                .orElse("");

        if (environmentLine.isEmpty()) {
            return "";
        }

        String environmentValue = environmentLine.replace("\"", "");

        Map<String, String> variables = Arrays.stream(environmentValue.split(","))
                .filter(variable -> variable.startsWith("X_FORWARDED_"))
                .map(variable -> variable.split("="))
                .collect(Collectors.toMap(
                        variable -> variable[0].substring("X_FORWARDED_".length()),
                        variable -> variable[1]
                ));

        return variables.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining(","));
    }
}
