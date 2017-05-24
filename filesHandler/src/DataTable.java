import java.util.Iterator;

public abstract class DataTable implements Iterable<DataRow> {
    @Override
    public Iterator<DataRow> iterator() {
        return new Iterator<DataRow>() {
            @Override
            public boolean hasNext() {
                //TODO
                return false;
            }

            @Override
            public DataRow next() {
                //TODO
                return null;
            }
        };
    }
}
