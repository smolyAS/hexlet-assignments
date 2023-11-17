package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class App {
    public static String getForwardedVariables(String configFileContent) {
        Map<String, String> variables = new HashMap<>();
        Pattern pattern = Pattern.compile("X_FORWARDED_(\\w+)=(\\w+)");
        Matcher matcher = pattern.matcher(configFileContent);

        while (matcher.find()) {
            String key = matcher.group(1);
            String value = matcher.group(2);
            variables.put(key, value);
        }

        Pattern envPattern = Pattern.compile("environment=\"(.+?)\"");
        Matcher envMatcher = envPattern.matcher(configFileContent);

        while (envMatcher.find()) {
            String envList = envMatcher.group(1);
            String[] envVariables = envList.split(",");
            for (String envVariable : envVariables) {
                String[] parts = envVariable.split("=");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    if (key.startsWith("X_FORWARDED_")) {
                        key = key.substring(12);
                        variables.put(key, value);
                    }
                }
            }
        }

        return variables.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining(","));
    }
}
