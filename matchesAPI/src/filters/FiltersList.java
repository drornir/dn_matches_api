package filters;

import java.util.List;

/**
 * Includes everything not under "Filter"
 */
public abstract class FiltersList {
    List<Filters> list;

    public FiltersList(List<Filters> list) {
        this.list = list;
    }
}
