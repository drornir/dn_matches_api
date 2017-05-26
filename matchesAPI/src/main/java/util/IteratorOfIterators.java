package util;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by Dror Nir on 26/05/2017.
 */
public class IteratorOfIterators<E> implements Iterator<E> {
    private final List<Iterator<E>> iteratorList;
    Iterator<E> curr;
    ListIterator<Iterator<E>> list;

    public IteratorOfIterators(List<Iterator<E>> iteratorList) {
        this.iteratorList = iteratorList;
        list = iteratorList.listIterator();
        if (list.hasNext()) {
            curr = list.next();
        }
    }

    @Override
    public boolean hasNext() {
        if (curr.hasNext()) {
            return true;
        } else if (list.hasNext()) {
            curr = list.next();
            return hasNext();
        } else {
            return false;
        }

    }

    @Override
    public E next() {
        if(hasNext()){
            return curr.next();
        }
        throw new NoSuchElementException();
    }
}
