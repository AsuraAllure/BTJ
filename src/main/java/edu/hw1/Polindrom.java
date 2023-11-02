package edu.hw1;

public class Polindrom {
    private static int getSumTwoCharacter(String a){
        return  Character.getNumericValue(a.charAt(0)) +
            Character.getNumericValue(a.charAt(1));
    }
    public static boolean isPolindromeDescendant(String representNumber){

        if (representNumber.equals(new StringBuilder(representNumber).reverse().toString()))
            return true;

        if (representNumber.length() == 2  &&
            getSumTwoCharacter(representNumber) < 10)
            return false;

        StringBuilder descedent = new StringBuilder();
        for(int i = 1; i < representNumber.length() ; i += 2){
            String sub_result =Integer.toString(
                getSumTwoCharacter(representNumber.substring(i-1, i+1))
            );
            descedent.append(sub_result);
        }
        return isPolindromeDescendant(descedent.toString());
    }
}
