package edu.hw3.task1;

public class Atbash {
    private Atbash() {
    }

    public static String encode(String source) {
        if (source == null) {
            throw new NullPointerException();
        }
        StringBuilder encodeStr = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            int codeCharacter = source.charAt(i);
            if ('A' <= codeCharacter && codeCharacter <= 'Z') {
                encodeStr.append((char) ('Z' - codeCharacter + 'A'));
            } else if ('a' <= codeCharacter && codeCharacter <= 'z') {
                encodeStr.append((char) ('z' - codeCharacter + 'a'));
            } else {
                encodeStr.append((char) codeCharacter);
            }
        }
        return encodeStr.toString();
    }

}
