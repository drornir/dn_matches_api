package data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public class KeyValueGame implements Game {
    private Map<GameField, GameValue> gameData = new HashMap<>();

    public KeyValueGame() {

    }

    public KeyValueGame(Map<String, String> fromRow) {
        //for each tuple in row, find a fieldEnum and add as tuple of Game.
        for (Map.Entry<String, String> entry : fromRow.entrySet()) {
            for (GameField field : GameField.values()) {
                if (entry.getKey().equals(field.getFieldNameInData())) {
                    add(field, new GameValue(field, entry.getValue()));
                }
            }
        }
    }

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

    public void addAll(HashMap<GameField, GameValue> fromMap) {
        gameData.putAll(fromMap);
    }
}
