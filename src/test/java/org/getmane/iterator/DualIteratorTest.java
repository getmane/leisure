package org.getmane.iterator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class DualIteratorTest {

    @Test
    void hasNext_OnlyLeftIteratorFilled_True() {
        // Given
        DualIterator<Integer> dualIterator = new DualIterator<>(
                getIterator(1),
                getIterator()
        );

        // When
        boolean hasNext = dualIterator.hasNext();

        // Then
        assertTrue(hasNext);
    }

    @Test
    void hasNext_OnlyRightIteratorFilled_True() {
        // Given
        DualIterator<Integer> dualIterator = new DualIterator<>(
                getIterator(),
                getIterator(2)
        );

        // When
        boolean hasNext = dualIterator.hasNext();

        // Then
        assertTrue(hasNext);
    }

    @Test
    void next_BothIteratorsFilled_AllValuesGiven() {
        // Given
        DualIterator<Integer> dualIterator = new DualIterator<>(
                getIterator(1),
                getIterator(2)
        );

        // When
        Integer first = dualIterator.next();
        Integer second = dualIterator.next();

        // Then
        assertEquals(1, first);
        assertEquals(2, second);
    }

    @Test
    void remove_BothIteratorsFilled_AllValuesRemoved() {
        // Given
        DualIterator<Integer> dualIterator = new DualIterator<>(
                getIterator(1),
                getIterator(2)
        );

        // When
        dualIterator.next();
        dualIterator.remove();

        dualIterator.next();
        dualIterator.remove();

        // Then
        assertFalse(dualIterator.hasNext());
    }

    private Iterator<Integer> getIterator(Integer... values) {
        return new ArrayList<>(Arrays.asList(values)).iterator();
    }
}