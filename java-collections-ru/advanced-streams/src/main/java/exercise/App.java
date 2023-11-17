package exercise;

import java.util.Arrays;
import java.util.stream.Collectors;

public class App {

    public static String getForwardedVariables(String configFileContent) {
        return Arrays.stream(configFileContent.split("\n"))
                .filter(line -> line.trim().startsWith("environment"))
                .map(line -> {
                    String variables = line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\""));
                    return Arrays.stream(variables.split(","))
                            .filter(pair -> pair.trim().startsWith("X_FORWARDED_"))
                            .map(pair -> {
                                String[] keyValue = pair.trim().split("=");
                                String name = keyValue[0].substring(keyValue[0].indexOf("_") + 1).replace("FORWARDED_", "");
                                String value = keyValue[1];
                                return name + value;
                            })
                            .collect(Collectors.joining(","));
                })
                .collect(Collectors.joining(","));
    }
}