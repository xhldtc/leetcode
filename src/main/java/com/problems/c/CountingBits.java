package com.problems.c;

import java.util.Arrays;

public class CountingBits {

    public int[] countBits(int num) {
        int[] res = new int[num + 1], tail = new int[num + 1];
        res[0] = 0;
        tail[0] = 0;
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] - tail[i - 1] + 1;
            tail[i] = tailBits(i);
        }
        return res;
    }

    int tailBits(int num) {
        int count = 0;
        while ((num & 1) == 1) {
            count++;
            num >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountingBits().countBits(5)));
    }
}
