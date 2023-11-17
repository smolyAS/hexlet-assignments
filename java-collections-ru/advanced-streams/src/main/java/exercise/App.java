package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class App {
    public static String getForwardedVariables(String configFileContent) {
        Map<String, String> variables = new HashMap<>();
        Pattern pattern = Pattern.compile("\\bX_FORWARDED_(\\w+)=(\\w+)\\b");
        Matcher matcher = pattern.matcher(configFileContent);

        while (matcher.find()) {
            String key = matcher.group(1);
            String value = matcher.group(2);
            variables.put(key, value);
        }

        return variables.entrySet().stream()
                .map(entry -> entry.getKey().toUpperCase() + "=" + entry.getValue())
                .collect(Collectors.joining(","));
    }
}