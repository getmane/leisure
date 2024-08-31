package org.getmane.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartAnalyzer {

    private CartAnalyzer() {}

    public static String[] process(String[] cart) {
        Map<String, List<Integer>> result = new HashMap<>();

        for (String item: cart) {
            String[] brandToPrice = item.split(",");
            String name = brandToPrice[0].strip();
            Integer price = Integer.valueOf(brandToPrice[1].strip());
            if (result.containsKey(name)) {
                Integer lowestPrice = Math.min(result.get(name).get(0), price);
                Integer highestPrice = Math.max(result.get(name).get(2), price);

                result.put(name, List.of(lowestPrice, price, highestPrice));
            } else {
                result.put(name, List.of(price, price, price));
            }
        }

        return result.entrySet().stream().map(entry -> {
            List<Integer> prices = entry.getValue();
            return entry.getKey() + ", " + prices.get(0) + ", " + prices.get(1) + ", " + prices.get(2);
        }).toArray(String[]::new);
    }
}
