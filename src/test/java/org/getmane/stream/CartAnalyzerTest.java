package org.getmane.stream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartAnalyzerTest {

    @Test
    void process_AllPriceCasesForBrand_PricesAreCorrect() {

        // When
        String[] cart = new String[] {"brand1, 5", "brand1, 3", "brand1, 10", "brand1, 6"};

        // Given
        String[] result = CartAnalyzer.process(cart);

        // Then
        assertArrayEquals(new String[] {"brand1, 3, 6, 10"}, result);
    }
}