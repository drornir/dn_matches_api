package filters.operators;

import data.Game;
import filters.Filters;
import filters.FiltersList;

import java.util.List;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public class Or extends FiltersList implements Filters {

    public Or(List<Filters> list) {
        super(list);
    }

    @Override
    public boolean isMatching(Game game) {
        for (Filters filters : list) {
            if(filters.isMatching(game))
                return true;
        }
        return false;
    }
}
