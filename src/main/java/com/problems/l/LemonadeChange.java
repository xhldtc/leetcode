package com.problems.l;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int[] have = new int[21];
        for (int bill : bills) {
            if (bill == 5) {
                have[5]++;
            } else if (bill == 10) {
                if (have[5] == 0) {
                    return false;
                }
                have[5]--;
                have[10]++;
            } else {
                if (have[10] == 0) {
                    if (have[5] < 3) {
                        return false;
                    }
                    have[5] -= 3;
                } else if (have[5] == 0) {
                    return false;
                } else {
                    have[10]--;
                    have[5]--;
                }
            }
        }
        return true;
    }
}
