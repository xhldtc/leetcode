package com.problems.a;

/**
 * @author xhldtc on 25/11/2018.
 */
public class AddDigits {

    public int addDigits(int num) {
        while (num > 9) {
            num = add(num);
        }
        return num;
    }

    public int add(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
