package org.getmane.stream;

import org.getmane.stream.FizzBuzzer;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzerTest {

    @Test
    void toFizzBuzz_Points3And5Input15_PrintsAllKeys() {
        // Given
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");

        FizzBuzzer fizzBuzzer = new FizzBuzzer(map, " ");

        // When
        var result = fizzBuzzer.toFizzBuzz(15);

        // Then
        assertEquals("1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz", result);
    }

    @Test
    void toFizzBuzz_Points3And5And10Input15_PrintsAllKeys() {
        // Given
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");
        map.put(10, "Bazz");

        FizzBuzzer fizzBuzzer = new FizzBuzzer(map, " ");

        // When
        var result = fizzBuzzer.toFizzBuzz(15);

        // Then
        assertEquals("1 2 Fizz 4 Buzz Fizz 7 8 Fizz BuzzBazz 11 Fizz 13 14 FizzBuzz", result);
    }
}