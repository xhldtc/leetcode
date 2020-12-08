package com.problems.r;

public class ReconstructOriginalDigitsFromEnglish {

    public String originalDigits(String s) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        int[] res = new int[10];
        int c;
        if (count['z' - 'a'] > 0) {
            c = count['z' - 'a'];
            res[0] = c;
            count['z' - 'a'] -= c;
            count['e' - 'a'] -= c;
            count['r' - 'a'] -= c;
            count['o' - 'a'] -= c;
        }
        if (count['x' - 'a'] > 0) {
            c = count['x' - 'a'];
            res[6] = c;
            count['s' - 'a'] -= c;
            count['i' - 'a'] -= c;
            count['x' - 'a'] -= c;
        }
        if (count['w' - 'a'] > 0) {
            c = count['w' - 'a'];
            res[2] = c;
            count['t' - 'a'] -= c;
            count['w' - 'a'] -= c;
            count['o' - 'a'] -= c;
        }
        if (count['s' - 'a'] > 0) {
            c = count['s' - 'a'];
            res[7] = c;
            count['s' - 'a'] -= c;
            count['e' - 'a'] -= c;
            count['v' - 'a'] -= c;
            count['e' - 'a'] -= c;
            count['n' - 'a'] -= c;
        }
        if (count['v' - 'a'] > 0) {
            c = count['v' - 'a'];
            res[5] = c;
            count['f' - 'a'] -= c;
            count['i' - 'a'] -= c;
            count['v' - 'a'] -= c;
            count['e' - 'a'] -= c;
        }
        if (count['f' - 'a'] > 0) {
            c = count['f' - 'a'];
            res[4] = c;
            count['f' - 'a'] -= c;
            count['o' - 'a'] -= c;
            count['u' - 'a'] -= c;
            count['r' - 'a'] -= c;
        }
        if (count['r' - 'a'] > 0) {
            c = count['r' - 'a'];
            res[3] = c;
            count['t' - 'a'] -= c;
            count['h' - 'a'] -= c;
            count['r' - 'a'] -= c;
            count['e' - 'a'] -= 2 * c;
        }
        if (count['t' - 'a'] > 0) {
            c = count['t' - 'a'];
            res[8] = c;
            count['e' - 'a'] -= c;
            count['i' - 'a'] -= c;
            count['g' - 'a'] -= c;
            count['h' - 'a'] -= c;
            count['t' - 'a'] -= c;
        }
        if (count['o' - 'a'] > 0) {
            c = count['o' - 'a'];
            res[1] = c;
            count['o' - 'a'] -= c;
            count['n' - 'a'] -= c;
            count['e' - 'a'] -= c;
        }
        if (count['i' - 'a'] > 0) {
            c = count['i' - 'a'];
            res[9] = c;
            count['n' - 'a'] -= 2 * c;
            count['i' - 'a'] -= c;
            count['e' - 'a'] -= c;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i]; j++) {
                sb.append((char) ('0' + i));
            }
        }
        return sb.toString();
    }
}
