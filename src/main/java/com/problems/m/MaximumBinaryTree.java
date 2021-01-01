package com.problems.m;

import com.structure.TreeNode;

public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length);
    }

    TreeNode build(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        } else if (start + 1 == end) {
            return new TreeNode(nums[start]);
        }
        int index = start, max = nums[start];
        for (int i = start + 1; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(nums[index]);
        node.left = build(nums, start, index);
        node.right = build(nums, index + 1, end);
        return node;
    }
}
