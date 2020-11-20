package com.problems.c;

import java.util.Arrays;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] input = new int[numCourses];
        int[] output = new int[numCourses];
        for (int[] pre : prerequisites) {
            output[pre[1]]++;
            input[pre[0]]++;
        }
        int[] res = new int[numCourses];
        int index = 0;
        boolean[] flag = new boolean[numCourses];

        while (true) {
            boolean find = false;
            for (int i = 0; i < output.length; i++) {
                if (output[i] > 0 && input[i] == 0) {
                    find = true;
                    for (int[] pre : prerequisites) {
                        if (pre[1] == i)
                            input[pre[0]]--;
                    }
                    output[i] = 0;
                    res[index++] = i;
                    flag[i] = true;
                }
            }
            if (!find)
                break;
        }
        for (int i = 0; i < output.length; i++) {
            if (output[i] > 0)
                return new int[]{};
            else if (!flag[i])
                res[index++] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CourseScheduleII().findOrder(1, new int[][]{})));
    }
}
