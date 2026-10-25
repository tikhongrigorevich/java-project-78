package hexlet.code.schemas;

public interface BaseSchema<T, V> {

    public T required();

    public boolean isValid(V param);
}
