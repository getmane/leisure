package stream;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzzer {

    private final Map<Integer, String> printPoints;
    private final String delimiter;

    public FizzBuzzer(Map<Integer, String> printPoints, String delimiter) {
        this.printPoints = printPoints;
        this.delimiter = delimiter;
    }

    public String toFizzBuzz(int number) {
        return IntStream.rangeClosed(1, number).boxed().map(
                num -> printPoints.entrySet().stream()
                        .filter(entry -> num % entry.getKey() == 0)
                        .map(Map.Entry::getValue)
                        .reduce(String::concat)
                        .orElse(String.valueOf(num))
        ).collect(Collectors.joining(delimiter));
    }
}
