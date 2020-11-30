package com.problems.r;

public class RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long x = overlap(A, C, E, G);
        long y = overlap(B, D, F, H);
        long res = (C - A) * (D - B) + (G - E) * (H - F) - x * y;
        return (int) res;
    }

    long overlap(long a, long b, long c, long d) {
        if (b <= c || d <= a) {
            return 0;
        }
        return Math.min(b, d) - Math.max(a, c);
    }
}
