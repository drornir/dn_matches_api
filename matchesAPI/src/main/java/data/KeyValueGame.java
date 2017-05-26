package data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public class KeyValueGame implements Game{
    private Map<GameField,GameValue> gameData = new HashMap<>();

    @Override
    public GameValue get(GameField fieldName) {
        return gameData.get(fieldName);
    }

    @Override
    public Set<Map.Entry<GameField, GameValue>> getAll() {
        return gameData.entrySet();
    }

    @Override
    public void add(GameField field, GameValue value) {
        gameData.put(field, value);
    }

    public void addAll(HashMap<GameField,GameValue> fromMap){
        gameData.putAll(fromMap);
    }
}
