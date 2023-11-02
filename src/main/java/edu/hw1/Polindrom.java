package edu.hw1;

public class Polindrom {
    private Polindrom() {
    }

    private static int getSumTwoCharacter(String a) {
        return Character.getNumericValue(a.charAt(0))
            + Character.getNumericValue(a.charAt(1));
    }

    public static boolean isPolindromeDescendant(String representNumber) {

        if (representNumber.equals(new StringBuilder(representNumber).reverse().toString())) {
            return true;
        }

        final int MIN_DESCEDENT = 10;

        if (representNumber.length() == 2
            && getSumTwoCharacter(representNumber) < MIN_DESCEDENT) {
            return false;
        }

        StringBuilder descedent = new StringBuilder();
        for (int i = 1; i < representNumber.length(); i += 2) {
            String subResult = Integer.toString(
                getSumTwoCharacter(representNumber.substring(i - 1, i + 1))
            );
            descedent.append(subResult);
        }
        return isPolindromeDescendant(descedent.toString());
    }
}
