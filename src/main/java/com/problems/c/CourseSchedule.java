package com.problems.c;

/**
 * 判断有向图是否有环，把只有出度没有入度的点连同边删掉，不断重复，直到没有点，就代表没环，否则就是有环
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] input = new int[numCourses];
        int[] output = new int[numCourses];
        for (int[] pre : prerequisites) {
            output[pre[0]]++;
            input[pre[1]]++;
        }

        while (true) {
            boolean find = false;
            for (int i = 0; i < output.length; i++) {
                if (output[i] > 0 && input[i] == 0) {
                    find = true;
                    for (int[] pre : prerequisites) {
                        if (pre[0] == i)
                            input[pre[1]]--;
                    }
                    output[i] = 0;
                }
            }
            if (!find)
                break;
        }
        for (int i = 0; i < output.length; i++) {
            if (output[i] > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CourseSchedule().canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
