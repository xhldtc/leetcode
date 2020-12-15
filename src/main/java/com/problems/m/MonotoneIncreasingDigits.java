package com.problems.m;

public class MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int N) {
        String s = String.valueOf(N);
        char[] chars = s.toCharArray();
        while (true) {
            int prev = 0;
            boolean increase = true;
            for (int i = 0; i < chars.length; i++) {
                int curr = chars[i] - '0';
                if (curr < prev) {
                    chars[i - 1] = (char) (prev - 1 + '0');
                    for (int j = i; j < chars.length; j++) {
                        chars[j] = '9';
                    }
                    increase = false;
                    break;
                }
                prev = curr;
            }
            if (increase)
                break;
        }
        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        System.out.println(new MonotoneIncreasingDigits().monotoneIncreasingDigits(10));
    }
}
