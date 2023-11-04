package edu.hw4;

import edu.hw4.Errors.HeightError;
import edu.hw4.Errors.NameError;
import edu.hw4.Errors.ValidateError;
import edu.hw4.Errors.WeightError;
import java.util.LinkedList;
import java.util.List;

public class Validator {
    public static final int MIN_LENGTH_NAME = 3;
    public static final int MAX_LENGTH_NAME = 15;
    public static final int MIN_HEIGHT = 0;
    public static final int MAX_HEIGHT = 60;
    public static final int MIN_WEIGHT = 0;
    public static final int MAX_WEIGHT = 15;

    private Validator() {
    }

    public static List<ValidateError> validate(Animal beast) {
        List<ValidateError> errorList = new LinkedList<>();
        if (beast.name().length() < MIN_LENGTH_NAME || beast.name().length() > MAX_LENGTH_NAME) {
            errorList.add(new NameError(beast.name()));
        }
        if (beast.height() < MIN_HEIGHT || beast.height() > MAX_HEIGHT) {
            errorList.add(new HeightError(beast.name()));
        }
        if (beast.weight() < MIN_WEIGHT || beast.weight() > MAX_WEIGHT) {
            errorList.add(new WeightError(beast.name()));
        }

        return errorList;
    }
}
