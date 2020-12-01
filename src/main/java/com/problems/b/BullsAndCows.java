package com.problems.b;

public class BullsAndCows {

    public String getHint(String secret, String guess) {
        int[] countA = new int[10], countB = new int[10];
        int bull = 0, cow = 0;
        for (int i = 0; i < secret.length(); i++) {
            char a = secret.charAt(i), b = guess.charAt(i);
            if (a == b) {
                bull++;
            } else {
                countA[a - '0']++;
                countB[b - '0']++;
            }
        }
        for (int i = 0; i < countA.length; i++) {
            cow += Math.min(countA[i], countB[i]);
        }
        return bull + "A" + cow + "B";
    }
}
