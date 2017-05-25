package filters.operators;

import data.Game;
import data.GameField;
import data.GameValue;
import filters.Filter;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public class Equality extends Filter {
    GameField fieldName;
    GameValue value;

    public Equality(GameField fieldName, GameValue value) {
        this.fieldName = fieldName;
        this.value = value;
    }

    @Override
    public boolean matches(Game game) {
        //TODO
        return false;
    }
}
