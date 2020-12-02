package com.problems.r;

public class RangeSumQueryMutable {

    Node root;
    int[] nums;

    public RangeSumQueryMutable(int[] nums) {
        root = build(nums, 0, nums.length);
        this.nums = nums;
    }

    public void update(int i, int val) {
        update(root, i, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return root == null ? 0 : sumRange(root, i, j + 1);
    }

    void update(Node node, int i, int diff){
        if(node != null && node.start<=i && i< node.end){
            node.sum += diff;
            update(node.left, i, diff);
            update(node.right, i, diff);
        }
    }

    int sumRange(Node node, int start, int end){
        if(node.start == start && node.end == end){
            return node.sum;
        }
        int mid = node.start + (node.end - node.start) /2;
        if(end<=mid){
            return sumRange(node.left, start, end);
        } else if(start>=mid){
            return sumRange(node.right, start, end);
        } else {
            return sumRange(node.left, start, mid) + sumRange(node.right, mid, end);
        }
    }

    Node build(int[] nums, int start, int end) {
        if(nums.length == 0){
            return null;
        } else if(start + 1 == end){
            return new Node(start, end, nums[start]);
        }
        int sum = 0;
        for(int i=start;i<end;i++){
            sum += nums[i];
        }
        Node node = new Node(start, end, sum);
        int mid = start + (end - start) / 2;
        node.left = build(nums, start, mid);
        node.right = build(nums, mid, end);
        return node;
    }

    static class Node {
        int start;
        int end;
        int sum;
        Node left;
        Node right;

        Node(int start, int end, int sum){
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        RangeSumQueryMutable r = new RangeSumQueryMutable(new int[]{0,9,5,7,3});
        System.out.println(r.sumRange(4,4));
        System.out.println(r.sumRange(2,4));
        System.out.println(r.sumRange(3,3));
//        r.update(4,5);
//        r.update(1,7);
//        r.update(0,8);
        System.out.println(r.sumRange(1,2));
        r.update(1,9);
        System.out.println(r.sumRange(4,4));
        r.update(3,4);
    }
}
