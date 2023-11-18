package edu.hw4.Errors;

public record HeightError(String beastName) implements ValidateError {
    @Override
    public String getBeastName() {
        return beastName;
    }
}
