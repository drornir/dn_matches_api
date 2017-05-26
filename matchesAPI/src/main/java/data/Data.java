package data;

import filters.Filters;
import io.GamesResource;
import io.PlayedGames;
import io.UpcomingGames;
import util.IteratorOfIterators;

import java.util.*;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public class Data {
    private static Data ourInstance = new Data();

    public static Data getInstance() {
        return ourInstance;
    }

    private Data() {
        //TODO
    }

    public Iterator<Game> getGames() {
        return getGames(null);
    }

    /**
     * The filters are used for optimization in I/O access, e.g use indexes.
     * Currently it doesn't look at filters (but i wanted to include this in the API of this class)
     *
     * @param filters
     * @return Iterator of relevant Rows
     */
    public Iterator<Game> getGames(@SuppressWarnings("unused") Filters filters) {
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
