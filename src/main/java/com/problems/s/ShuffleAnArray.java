package com.problems.s;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {

    private int[] original;
    private Random random = new Random();

    public ShuffleAnArray(int[] nums) {
        original = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] array = Arrays.copyOf(original, original.length);
        for (int i = 0; i < array.length; i++) {
            int index = random.nextInt(array.length);
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        return array;
    }
}
