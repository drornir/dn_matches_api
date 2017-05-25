package filters;

import data.Game;

import java.util.List;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public class Or extends FiltersList implements Filters {

    public Or(List<Filters> list) {
        super(list);
    }

    @Override
    public boolean matches(Game game) {
        for (Filters filters : list) {
            if(filters.matches(game))
                return true;
        }
        return false;
    }
}
