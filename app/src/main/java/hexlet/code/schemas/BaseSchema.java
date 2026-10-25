package hexlet.code.schemas;

public interface BaseSchema<T, V> {

    T required();

    boolean isValid(V param);
}
