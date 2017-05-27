package query.filters.operators;


import data.Game;
import query.filters.Filters;
import query.filters.FiltersList;

import java.util.List;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public class And extends FiltersList implements Filters {

    public And(List<Filters> list) {
        super(list);
    }

    @Override
    public boolean isMatching(Game game) {
        for (Filters filters : list) {
            if(!filters.isMatching(game))
                return false;
        }
        return true;
    }
}
