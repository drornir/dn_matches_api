package query.filters;

import data.Game;

/**
 * defines a set of constraints and the relationship between them.
 */
public interface Filters {
    boolean isMatching(Game game);
}
