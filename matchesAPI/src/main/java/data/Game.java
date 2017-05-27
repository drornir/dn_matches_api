package data;


import java.util.Map;
import java.util.Set;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public interface Game {
    GameValue get(GameField field);
    Set<Map.Entry<GameField, GameValue>> getAll();
    void add(GameField field,GameValue value);
}
