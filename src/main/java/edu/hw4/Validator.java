package edu.hw4;

import edu.hw4.Errors.HeightError;
import edu.hw4.Errors.NameError;
import edu.hw4.Errors.ValidateError;
import edu.hw4.Errors.WeightError;

import java.util.LinkedList;
import java.util.List;

public class Validator {
    public static List<ValidateError> validate(Animal beast) {
        List<ValidateError> errorList = new LinkedList<>();
        if (beast.name().length() < 3 || beast.name().length() > 15) {
            errorList.add(new NameError(beast.name()));
        }
        if (beast.height() < 0 || beast.height() > 600) {
            errorList.add(new HeightError(beast.name()));
        }
        if (beast.weight() < 0 || beast.weight() > 100) {
            errorList.add(new WeightError(beast.name()));
        }

        return errorList;
    }
}
