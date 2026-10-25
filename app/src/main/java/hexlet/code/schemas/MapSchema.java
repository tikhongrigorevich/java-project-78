package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema implements BaseSchema<MapSchema, Map<?, ?>> {
    private final Map<String, Predicate<Map<?, ?>>> checks = new HashMap<>();

    @Override
    public MapSchema required() {
        checks.put("required", Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int size) {
        checks.put("sizeof", map -> map != null && map.size() == size);
        return this;
    }

    @Override
    public boolean isValid(Map<?, ?> param) {
        if (param == null) {
            return !checks.containsKey("required");
        }

        for (var check : checks.values()) {
            if (!check.test(param)) {
                return false;
            }
        }

        return true;
    }
}
