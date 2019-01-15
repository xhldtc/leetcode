package com.problems.m;

/**
 * @author xhldtc on 2019-01-15.
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        } else if (num1.length() < num2.length()) {
            return multiply(num2, num1);
        }
        String result = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int d = num2.charAt(i) - '0';
            StringBuilder res = singleMultiply(num1, d);
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                res.append('0');
            }
            result = add(result, res.toString());
        }
        return result;
    }

    private String add(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int plus = 0;
        StringBuilder sum = new StringBuilder();
        for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            int d1 = i < num1.length() ? num1.charAt(i) - '0' : 0;
            int d2 = i < num2.length() ? num2.charAt(i) - '0' : 0;
            int num = d1 + d2 + plus;
            sum.append(num % 10);
            plus = num / 10;
        }
        if (plus != 0) {
            sum.append(plus);
        }
        return sum.reverse().toString();
    }

    private StringBuilder singleMultiply(String num, int digit) {
        if (digit == 0) {
            return new StringBuilder("0");
        } else if (digit == 1) {
            return new StringBuilder(num);
        }
        int plus = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            int d = num.charAt(i) - '0';
            int m = d * digit;
            sb.append((m + plus) % 10);
            plus = (m + plus) / 10;
        }
        if (plus != 0) {
            sb.append(plus);
        }
        return sb.reverse();
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("2", "3"));
    }
}
