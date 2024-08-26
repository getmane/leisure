package org.getmane.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorTestUtils {

    public static void removeElements(int iterations, Iterator<Integer> iterator) {
        for (int i = 0; i < iterations; i++) {
            iterator.next();
            iterator.remove();
        }
    }

    public static Iterator<Integer> getIterator(Integer... values) {
        return new ArrayList<>(Arrays.asList(values)).iterator();
    }
}
