package edu.hw3.task4;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class RomeNumber {
    private static final List<AbstractMap.SimpleEntry<String, Integer>> ROME_NUMBER_MAP = new ArrayList<>(
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

    private RomeNumber() {
    }

    public static String toRomeNumber(int arabNumber) {

        int arabianNumber = arabNumber;
        StringBuilder romeNumber = new StringBuilder();

        int countSymbol;
        for (int j = 0; j < ROME_NUMBER_MAP.size() - 1; j++) {
            countSymbol = arabianNumber / ROME_NUMBER_MAP.get(j).getValue();
            romeNumber.append(ROME_NUMBER_MAP.get(j).getKey().repeat(countSymbol));

            arabianNumber %= ROME_NUMBER_MAP.get(j).getValue();

            int subIndex = (j / 2) * 2 + 2;
            if (arabianNumber >= ROME_NUMBER_MAP.get(j).getValue() - ROME_NUMBER_MAP.get(subIndex).getValue()) {
                romeNumber.append(ROME_NUMBER_MAP.get(subIndex).getKey().concat(ROME_NUMBER_MAP.get(j).getKey()));
                arabianNumber -= ROME_NUMBER_MAP.get(j).getValue() - ROME_NUMBER_MAP.get(subIndex).getValue();
            }
        }
        romeNumber.append("I".repeat(arabianNumber));
        return romeNumber.toString();
    }
}
