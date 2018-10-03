package com.problems;

import com.structure.TreeNode;

import java.util.Arrays;

public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        } else if (nums.length == 1) {
            return new TreeNode(nums[0]);
        } else if (nums.length == 2) {
            TreeNode node = new TreeNode(nums[0]);
            node.right = new TreeNode(nums[1]);
            return node;
        } else {
            int mid = nums.length / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
            node.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
            return node;
        }
    }
}
