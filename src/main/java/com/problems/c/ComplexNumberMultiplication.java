package com.problems.c;

public class ComplexNumberMultiplication {

    public String complexNumberMultiply(String a, String b) {
        int[] x = parse(a);
        int[] y = parse(b);
        int a1 = x[0], b1 = x[1], a2 = y[0], b2 = y[1];
        int aa = a1 * a2 - b1 * b2;
        int bb = a1 * b2 + a2 * b1;
        return aa + "+" + bb + "i";
    }

    int[] parse(String a) {
        int plus = a.indexOf('+');
        int i = a.indexOf('i');
        String x = a.substring(0, plus);
        String y = a.substring(plus + 1, i);
        return new int[]{Integer.parseInt(x), Integer.parseInt(y)};
    }
}
