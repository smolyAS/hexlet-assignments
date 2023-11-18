package exercise;

import java.util.Arrays;
import java.util.stream.Collectors;

public class App {

    public static String getForwardedVariables(String configFile) {
        return Arrays.stream(configFile.split("\n"))
                .filter(line -> line.startsWith("environment=\""))
                .map(line -> line.substring("environment=\"".length(), line.length() - 1))
                .flatMap(line -> Arrays.stream(line.split(",")))
                .map(String::trim)
                .filter(line -> line.startsWith("X_FORWARDED_"))
                .collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        String configFile = "environment=\"X_FORWARDED_variable=value,   \"\nkey=value";
        String forwardedVariables = getForwardedVariables(configFile);
        System.out.println(forwardedVariables);
    }
}
