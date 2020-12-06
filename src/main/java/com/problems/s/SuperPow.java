package com.problems.s;

public class SuperPow {

    public int superPow(int a, int[] b) {
        a = a % 1337;
        int res = 1, curr;
        for (int digit : b) {
            curr = res;
            for (int i = 0; i < 9; i++)
                res = (res * curr) % 1337;
            for (int i = 0; i < digit; i++)
                res = (res * a) % 1337;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SuperPow().superPow(2147483647, new int[]{2, 0, 0}));
    }
}
