package com.problems.b;

public class BuildingBoxes {

    public int minimumBoxes(int n) {
        int i, total = 0;
        for (i = 1; ; i++) {
            total += k(i);
            if (total > n) {
                total -= k(i);
                break;
            }
        }
        for (int x = 0; x <= i; x++) {
            if (total + k(x) >= n) {
                return x + k(i - 1);
            }
        }
        return -1;
    }

    int k(int i) {
        return (1 + i) * i / 2;
    }

    public static void main(String[] args) {
        System.out.println(new BuildingBoxes().minimumBoxes(16));
    }
}
