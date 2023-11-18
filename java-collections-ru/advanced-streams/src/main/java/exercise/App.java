package exercise;

import java.util.Arrays;
import java.util.stream.Collectors;

public class App {
    public static String getForwardedVariables(String configFile) {
        return Arrays.stream(configFile.split("\n"))
                .filter(line -> line.startsWith("environment\""))
                .map(line -> line.substring("environment\"".length()))
                .flatMap(variables -> Arrays.stream(variables.split(",")))
                .map(String::trim)
                .filter(variable -> variable.startsWith("X_FORWARDED_"))
                .map(variable -> variable.substring("X_FORWARDED_".length()))
                .collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        String configFile = "environment\"X_FORWARDED_MAILtirion@google.com,X_FORWARDED_HOME/home/tirion,languageen\"";
        String forwardedVariables = getForwardedVariables(configFile);
        System.out.println(forwardedVariables);
    }
}
