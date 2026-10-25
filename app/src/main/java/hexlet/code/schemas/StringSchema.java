package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class StringSchema {
    private final Map<String, Predicate<String>> checks = new HashMap<>();

    public StringSchema required() {
        checks.put("required", value -> value != null && !value.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        checks.put("minLength", value -> value.length() >= length);
        return this;
    }

    public StringSchema contains(String subStr) {
        checks.put("contains", value -> value.contains(subStr));
        return this;
    }

    public boolean isValid(String str) {
        for (var check : checks.values()) {
            if(!check.test(str)) {
                return false;
            }
        }

        return true;
    }
}
