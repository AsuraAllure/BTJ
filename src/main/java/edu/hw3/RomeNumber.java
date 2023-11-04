package edu.hw3;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class RomeNumber {

    public static String toRomeNumber(int arabianNumber) {
        StringBuilder romeNumber = new StringBuilder();
        final ArrayList<AbstractMap.SimpleEntry<String, Integer>> dict = new ArrayList<>(
            List.of(
                new AbstractMap.SimpleEntry<>("M", 1000),
                new AbstractMap.SimpleEntry<>("D", 500),
                new AbstractMap.SimpleEntry<>("C", 100),
                new AbstractMap.SimpleEntry<>("L", 50),
                new AbstractMap.SimpleEntry<>("X", 10),
                new AbstractMap.SimpleEntry<>("V", 5),
                new AbstractMap.SimpleEntry<>("I", 1)
            )
        );

        int countSymbol;
        for (int j = 0; j < dict.size() - 1; j++) {
            countSymbol = arabianNumber / dict.get(j).getValue();
            romeNumber.append(dict.get(j).getKey().repeat(countSymbol));

            arabianNumber %= dict.get(j).getValue();

            int subIndex = (j / 2) * 2 + 2;
            if (arabianNumber >= dict.get(j).getValue() - dict.get(subIndex).getValue()) {
                romeNumber.append(dict.get(subIndex).getKey().concat(dict.get(j).getKey()));
                arabianNumber -= dict.get(j).getValue() - dict.get(subIndex).getValue();
            }
        }
        romeNumber.append("I".repeat(arabianNumber));
        return romeNumber.toString();
    }
}
