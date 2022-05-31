package uebung03.HashTable;

public class Value {
    Object value;
    Object key;
    boolean overwrite = false;

    public Value(Object value, Object key) {
        this.value = value;
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
