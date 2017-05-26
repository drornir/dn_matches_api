package filters;

import data.GameField;
import data.GameValue;

/**
 * Defines a terminal "Filters" type.
 * E.g eq,neq,lte....
 */
public abstract class Filter implements Filters {
    public GameField fieldName;
    public GameValue value;
}
