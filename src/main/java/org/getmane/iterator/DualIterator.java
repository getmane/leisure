package org.getmane.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DualIterator<T> implements Iterator<T> {

    private final Iterator<T> left;
    private final Iterator<T> right;

    private int current = 0; // 0 = no iterator, 1 - left, 2 - right

    public DualIterator(Iterator<T> left, Iterator<T> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean hasNext() {
        return left.hasNext() || right.hasNext();
    }

    @Override
    public T next() {
        if (left.hasNext()) {
            current = 1; // case: left.hasNext() is false but remove() has one more left element to delete
            return left.next();
        }
        current = 2;
        return right.next();
    }

    @Override
    public void remove() {
        if (current == 0) {
            throw new NoSuchElementException("Element not present");
        } else if (current == 1) {
            left.remove();
        } else {
            right.remove();
        }
    }
}
