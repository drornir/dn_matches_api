package query;

import data.Game;
import filters.Filters;

import java.util.Iterator;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public class QueryEngine {
    private static QueryEngine engine = new QueryEngine();

    public static QueryEngine getInstance() {
        return engine;
    }

    private QueryEngine() {
    }

    public Iterator<Game> query(Filters filters){
        //TODO
        return null;
    }
}
