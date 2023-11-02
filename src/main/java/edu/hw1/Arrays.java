package edu.hw1;

public class Arrays {
    private Arrays() {
    }

    public static boolean attachedArray(int[] a, int[] b) {
        int minLength = Math.min(a.length, b.length);

        if (minLength == 0) {
            return a.length == 0;
        }

        int minA = a[0];
        int maxA = a[0];
        int minB = b[0];
        int maxB = b[0];

        for (int i = 1; i < minLength; i += 1) {
            if (a[i] > maxA) {
                maxA = a[i];
            }
            if (a[i] < minA) {
                minA = a[i];
            }

            if (b[i] > maxB) {
                maxB = b[i];
            }
            if (b[i] < minB) {
                minB = b[i];
            }
        }
        if (a.length > b.length) {
            for (int i = minLength + 1; i < a.length; i += 1) {
                if (a[i] > maxA) {
                    maxA = a[i];
                }
                if (a[i] < minA) {
                    minA = a[i];
                }
            }
        }
        if (b.length > a.length) {
            for (int i = minLength + 1; i < b.length; i += 1) {
                if (b[i] > maxB) {
                    maxB = b[i];
                }
                if (b[i] < minB) {
                    minB = b[i];
                }
            }
        }
        return minA > minB && maxA < maxB;
    }
}
