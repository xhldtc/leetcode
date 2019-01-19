package com.problems.t;

import java.util.Arrays;

/**
 * @author xhldtc on 2019-01-19.
 */
public class TrappingRainWater {

    /**
     * 说下我的思路：从左右边界取较小的一边开始遍历，直到碰到比这个边大的条，遍历同时计算这一段的雨水，然后递归调用剩下子数组直至结束
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height.length == 0 || height.length == 1 || height.length == 2) {
            return 0;
        }
        int sum = 0;
        if (height[0] < height[height.length - 1]) {
            for (int i = 1; i < height.length; i++) {
                if (height[i] < height[0]) {
                    sum += height[0] - height[i];
                } else {
                    return sum + trap(Arrays.copyOfRange(height, i, height.length));
                }
            }
        } else {
            for (int i = height.length - 2; i >= 0; i--) {
                if (height[i] < height[height.length - 1]) {
                    sum += height[height.length - 1] - height[i];
                } else {
                    return sum + trap(Arrays.copyOfRange(height, 0, i + 1));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
