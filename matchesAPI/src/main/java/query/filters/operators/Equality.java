package query.filters.operators;

import data.Game;
import data.GameField;
import data.GameValue;
import query.filters.Filter;

import java.util.Map;
import java.util.Set;


public class Equality extends Filter {

    public Equality(GameField fieldName, GameValue value) {
        this.fieldName = fieldName;
        this.value = value;
    }

    @Override
    public boolean isMatching(Game game) {
        Set<Map.Entry<GameField, GameValue>> entries = game.getAll();
        for (Map.Entry<GameField, GameValue> entry : entries) {
            if (this.fieldName.equals(entry.getKey()) && this.value.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }
}
