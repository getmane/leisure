package org.getmane.iterator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MultiIteratorTest {

    @Test
    void hasNext_IsFilled_True() {
        // Given
        MultiIterator<Integer> multiIterator = new MultiIterator<>(List.of(getIterator(1), getIterator()));

        // When
        boolean hasNext = multiIterator.hasNext();

        // Then
        assertTrue(hasNext);
    }

    @Test
    void hasNext_NotFilled_False() {
        // Given
        MultiIterator<Integer> multiIterator = new MultiIterator<>(List.of(getIterator()));

        // When
        boolean hasNext = multiIterator.hasNext();

        // Then
        assertFalse(hasNext);
    }

    @Test
    void next_MultipleIteratorsFilled_AllValuesGiven() {
        // Given
        MultiIterator<Integer> multiIterator = new MultiIterator<>(
                List.of(getIterator(1), getIterator(2), getIterator(3))
        );

        // When
        Integer first = multiIterator.next();
        Integer second = multiIterator.next();
        Integer third = multiIterator.next();

        // Then
        assertEquals(1, first);
        assertEquals(2, second);
        assertEquals(3, third);
    }

    @Test
    void remove_MultipleIteratorsFilled_AllValuesRemoved() {
        // Given
        int totalCount = 3;
        MultiIterator<Integer> multiIterator = new MultiIterator<>(
                List.of(getIterator(1), getIterator(2), getIterator(3))
        );

        // When
        for (int i = 0; i < totalCount; i++) {
            multiIterator.next();
            multiIterator.remove();
        }

        // Then
        assertFalse(multiIterator.hasNext());
    }

    @Test
    void remove_MultipleIteratorsFilledWithMany_AllValuesRemoved() {
        // Given
        int totalCount = 7;
        MultiIterator<Integer> multiIterator = new MultiIterator<>(
                List.of(getIterator(1, 2), getIterator(3, 4), getIterator(5, 6, 7))
        );

        // When
        for (int i = 0; i < totalCount; i++) {
            multiIterator.next();
            multiIterator.remove();
        }

        // Then
        assertFalse(multiIterator.hasNext());
    }

    private Iterator<Integer> getIterator(Integer... values) {
        return new ArrayList<>(Arrays.asList(values)).iterator();
    }
}