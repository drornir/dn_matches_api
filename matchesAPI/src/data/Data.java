package data;

import filters.Filters;

import java.util.Iterator;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public class Data {
    private static Data ourInstance = new Data();

    public static Data getInstance() {
        return ourInstance;
    }

    private Data() {
        //TODO
    }

    public Iterator<Game> getRows() {
        return this.getRows(null);
    }

    /**
     * The filters are used for optimization in I/O access, e.g use indexes.
     * It should read from a single file if there's an equality filter on "status"
     * @param filters
     * @return Iterator of relevant Rows
     */
    public Iterator<Game> getRows(Filters filters) {
        //TODO
        return null;
    }
}
