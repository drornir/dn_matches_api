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
/*//TODO delete this
    @Override
    public Map<String, String> toStringsMap() {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<GameField, GameValue> dataEntry : gameData.entrySet()) {
            if (dataEntry.getKey().equals(GameField.STATUS)) {
                result.put("status", (String) dataEntry.getValue().getValue());
            } else if (dataEntry.getKey().equals(GameField.HOME_TEAM) || dataEntry.getKey().equals(GameField.AWAY_TEAM)) {
                Team team = (Team) dataEntry.getValue().getValue();
                result.put(dataEntry.getKey().getFieldNameInData(),)
            }
        }
    }*/

    public void addAll(HashMap<GameField, GameValue> fromMap) {
        gameData.putAll(fromMap);
    }
}
