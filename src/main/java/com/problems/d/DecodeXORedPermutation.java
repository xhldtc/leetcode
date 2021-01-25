package com.problems.d;

public class DecodeXORedPermutation {

    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int all = 0;
        for (int i = 1; i <= n; i++) {
            all ^= i;
        }
        for (int i = 1; i < encoded.length; i += 2) {
            all ^= encoded[i];
        }
        int[] res = new int[n];
        res[0] = all;
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] ^ encoded[i - 1];
        }
        return res;
    }
}
