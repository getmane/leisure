package org.getmane.iterator;

import org.junit.jupiter.api.Test;

import static org.getmane.iterator.IteratorTestUtils.getIterator;
import static org.getmane.iterator.IteratorTestUtils.removeElements;
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
        int elemCount = 2;
        DualIterator<Integer> dualIterator = new DualIterator<>(
                getIterator(1),
                getIterator(2)
        );

        // When
        removeElements(elemCount, dualIterator);

        // Then
        assertFalse(dualIterator.hasNext());
    }

    @Test
    void remove_BothIteratorsFilledWithMany_AllValuesRemoved() {
        // Given
        int elemCount = 5;
        DualIterator<Integer> dualIterator = new DualIterator<>(
                getIterator(1, 2),
                getIterator(3, 4, 5)
        );

        // When
        removeElements(elemCount, dualIterator);

        // Then
        assertFalse(dualIterator.hasNext());
    }
}