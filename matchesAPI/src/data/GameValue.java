package data;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public class GameValue {
    final private String value;

    public GameValue(String value) {
        assert value != null;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameValue that = (GameValue) o;

        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        //noinspection RedundantStringToString
        return value.toString();
    }
}
