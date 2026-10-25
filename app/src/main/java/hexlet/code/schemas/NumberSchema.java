package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema implements BaseSchema<NumberSchema, Integer> {
    private final Map<String, Predicate<Integer>> checks = new HashMap<>();

    @Override
    public NumberSchema required() {
        checks.put("required", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        checks.put("positive", value -> value > 0);
        return this;
    }

    public NumberSchema range(int start, int end) {
        checks.put("range", value -> value >= start && value <= end);
        return this;
    }

    @Override
    public boolean isValid(Integer value) {
        if (value == null) {
            return !checks.containsKey("required");
        }

        for (var check : checks.values()) {
            if (!check.test(value)) {
                return false;
            }
        }

        return true;
    }
}
