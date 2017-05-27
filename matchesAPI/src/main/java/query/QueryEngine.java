package query;

import data.Data;
import data.Game;
import query.filters.Filters;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public class QueryEngine {
    private static QueryEngine engine = new QueryEngine();

    public static QueryEngine getInstance() {
        return engine;
    }

    private QueryEngine() {
    }

    public Iterator<Game> query(Filters filters) throws Exception {
        Iterator<Game> games = Data.getInstance().getGames(filters);
        final Game firstGame;
        if (games.hasNext()) {
            firstGame = games.next();
        } else {
            firstGame = null;
        }
        return new Iterator<Game>() {
            Game game = firstGame;

            @Override
            public boolean hasNext() {
                if (game == null) {
                    return false;
                }
                while (!filters.isMatching(game)) {
                    if (games.hasNext()) {
                        game = games.next();
                    } else {
                        game = null;
                        return false;
                    }
                }
                return true;
            }

            @Override
            public Game next() {
                if (hasNext()) {
                    return game;
                }
                throw new NoSuchElementException();
            }
        };
    }
}
