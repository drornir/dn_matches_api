package data;

import query.filters.Filters;
import io.input.GamesResource;
import io.input.PlayedGames;
import io.input.UpcomingGames;
import util.IteratorOfIterators;

import java.util.*;

public class Data {
    private static Data ourInstance = new Data();

    public static Data getInstance() {
        return ourInstance;
    }

    private Data() {
    }

    public Iterator<Game> getGames() throws Exception {
        return getGames(null);
    }

    /**
     * The filters are used for optimization in I/O access, e.g use indexes.
     * Currently it doesn't look at filters (but i wanted to include this in the API of this class)
     *
     * @param filters unused
     * @return Iterator of relevant Rows
     */
    public Iterator<Game> getGames(@SuppressWarnings("unused") Filters filters) throws Exception {
        List<GamesResource> listDefinition = Arrays.asList(// optimize this
                new PlayedGames(),
                new UpcomingGames());
        List<Iterator<Game>> iteratorsList = new ArrayList<>();
        for (GamesResource resource : listDefinition) {
            iteratorsList.add(resource.getGames());
        }
        return new IteratorOfIterators<>(iteratorsList);
    }
}
