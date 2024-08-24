package org.getmane.iterator;

import java.util.Iterator;
import java.util.List;

public class MultiIterator<T> implements Iterator<T> {

    private final List<Iterator<T>> iterators;

    private int current = 0; // index of current iterator

    public MultiIterator(List<Iterator<T>> iterators) {
        this.iterators = iterators;
    }

    @Override
    public boolean hasNext() {
        return iterators.stream().map(Iterator::hasNext).findFirst().orElse(false);
    }

    @Override
    public T next() {
        return iterators.get(current).hasNext()
                ? iterators.get(current).next()
                : iterators.get(++current).next();
    }

    @Override
    public void remove() {
        iterators.get(current).remove();
    }
}
