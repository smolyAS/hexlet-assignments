package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String getForwardedVariables(String config) {
        Map<String, String> variables = new HashMap<>();

        Stream<String> lines = config.lines();
        lines.filter(line -> line.startsWith("environment"))
                .map(line -> line.split("\""))
                .filter(parts -> parts.length >= 2)
                .flatMap(parts -> Stream.of(parts[1].split(",")))
                .filter(envVariable -> envVariable.startsWith("X_FORWARDED_"))
                .map(envVariable -> envVariable.split("="))
                .filter(keyValue -> keyValue.length >= 2)
                .forEach(keyValue -> variables.put(keyValue[0].substring("X_FORWARDED_".length()), keyValue[1]));

        return variables.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .reduce((s1, s2) -> s1 + "," + s2)
                .orElse("");
    }
}
//END
