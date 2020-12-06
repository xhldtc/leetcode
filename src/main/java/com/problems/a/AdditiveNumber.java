package com.problems.a;

public class AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= num.length() / 2; i++) {
            for (int j = 1; ; j++) {
                int remain = num.length() - i - j;
                if (remain < Math.max(i, j)) {
                    break;
                }
                String s1 = num.substring(0, i);
                String s2 = num.substring(i, i + j);
                if ((s1.charAt(0) == '0' && s1.length() > 1) || (s2.charAt(0) == '0' && s2.length() > 1)) {
                    continue;
                }
                long num1 = Long.parseLong(s1);
                long num2 = Long.parseLong(s2);
                boolean b = solve(num1, num2, num.substring(i + j));
                if (b)
                    return true;
            }
        }
        return false;
    }

    boolean solve(long x, long y, String num) {
        long sum = x + y;
        String res = String.valueOf(sum);
        if (num.equals(res)) {
            return true;
        } else if (num.startsWith(res)) {
            return solve(y, sum, num.substring(res.length()));
        } else {
            return false;
        }
    }
}
