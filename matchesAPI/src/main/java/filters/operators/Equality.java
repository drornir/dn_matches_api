package filters.operators;

import data.Game;
import data.GameField;
import data.GameValue;
import filters.Filter;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public class Equality extends Filter {

    public Equality(GameField fieldName, GameValue value) {
        this.fieldName = fieldName;
        this.value = value;
    }

    @Override
    public boolean isMatching(Game game) {
        //TODO
        Set<Map.Entry<GameField, GameValue>> entries = game.getAll();
        for (Map.Entry<GameField, GameValue> entry : entries) {
            if (this.fieldName.equals(entry.getKey()) && this.value.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }
}
