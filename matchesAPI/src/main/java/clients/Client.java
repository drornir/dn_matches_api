package clients;

import filters.Filters;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public interface Client {
    Filters interpret(Object input) throws IllegalArgumentException;
}
