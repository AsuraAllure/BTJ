package edu.hw4.Errors;

public record WeightError(String nameBeast) implements ValidateError {
    @Override
    public String getBeastName() {
        return nameBeast;
    }
}
