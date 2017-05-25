package data;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public interface Game {
    GameValue get(GameField field);
    void add(GameField field,GameValue value);
}
