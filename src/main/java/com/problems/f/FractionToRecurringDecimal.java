package com.problems.f;

import java.util.ArrayList;
import java.util.List;

public class FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        boolean positive = (numerator > 0 && denominator > 0) || (numerator < 0 && denominator < 0);
        long numeratorL = numerator;
        long denominatorL = denominator;
        numeratorL = Math.abs(numeratorL);
        denominatorL = Math.abs(denominatorL);
        StringBuilder sb = new StringBuilder();
        if (!positive)
            sb.append('-');
        long div = numeratorL / denominatorL;
        long mod = numeratorL % denominatorL;
        sb.append(div);
        if (mod == 0) {
            return sb.toString();
        }
        sb.append(".");
        List<Long> modList = new ArrayList<>();
        List<String> resList = new ArrayList<>();

        while (mod != 0) {
            int index = modList.indexOf(mod);
            if (index != -1) {
                StringBuilder repeat = new StringBuilder();
                for (int i = index; i < resList.size(); i++) {
                    repeat.append(resList.get(i));
                }
                if (sb.toString().endsWith(repeat.toString())) {
                    sb.delete(sb.length() - repeat.length(), sb.length());
                }
                sb.append('(').append(repeat.toString()).append(')');
                break;
            }
            Object[] obj = divide(mod * 10L, denominatorL);
            sb.append(obj[0]);
            modList.add(mod);
            resList.add(obj[0].toString());
            mod = (Long) obj[1];
        }
        return sb.toString();
    }

    Object[] divide(long mod, long denominator) {
        StringBuilder sb = new StringBuilder();
        while (mod < denominator) {
            sb.append('0');
            mod *= 10L;
        }
        sb.append(mod / denominator);
        return new Object[]{sb.toString(), mod % denominator};
    }

    public static void main(String[] args) {
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(-1, Integer.MIN_VALUE));
    }
}
