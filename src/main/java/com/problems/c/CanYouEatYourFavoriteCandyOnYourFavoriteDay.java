package com.problems.c;

import java.util.Arrays;

public class CanYouEatYourFavoriteCandyOnYourFavoriteDay {

    public boolean[] canEat(int[] a, int[][] q) {
        int[] sum = new int[a.length+1];
        for(int i=0;i<a.length;i++) {
            sum[i+1] = sum[i] + a[i];
        }
        boolean[] res = new boolean[q.length];
        for(int i=0;i<res.length;i++) {
            int type = q[i][0];
            int day = q[i][1];
            int cap = q[i][2];
            int min = day+1;
            long tmp = (day+1) * cap;
            int max = (int) Math.min(tmp, (long)Integer.MAX_VALUE);
            int left = sum[type]+1;
            int right = sum[type+1];
            res[i] = max >=left &&  min<=right;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CanYouEatYourFavoriteCandyOnYourFavoriteDay().canEat(new int[]{5215,14414,67303,93431,44959,34974,22935,64205,28863,3436,45640,34940,38519,5705,14594,30510,4418,87954,8423,65872,79062,83736,47851,64523,15639,19173,88996,97578,1106,17767,63298,8620,67281,76666,50386,97303,26476,95239,21967,31606,3943,33752,29634,35981,42216,88584,2774,3839,81067,59193,225,8289,9295,9268,4762,2276,7641,3542,3415,1372,5538,878,5051,7631,1394,5372,2384,2050,6766,3616,7181,7605,3718,8498,7065,1369,1967,2781,7598,6562,7150,8132,1276,6656,1868,8584,9442,8762,6210,6963,4068,1605,2780,556,6825,4961,4041,4923,8660,4114},
                new int[][]{
                        {91,244597,840227137}
                })));
    }
}
