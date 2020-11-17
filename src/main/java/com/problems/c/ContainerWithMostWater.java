package com.problems.c;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(Math.min(height[left], height[right]) * (right - left), max);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}
