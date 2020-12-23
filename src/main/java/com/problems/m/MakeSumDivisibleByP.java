package com.problems.m;

import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP {

    public int minSubarray(int[] nums, int p) {
        nums[0] = nums[0] % p;
        for(int i=1;i<nums.length;i++){
            nums[i] = (nums[i] + nums[i-1]) % p;
        }
        int diff = nums[nums.length-1];
        if(diff == 0){
            return 0;
        }
        Map<Integer, Integer> map =new HashMap<>();
        map.put(0, -1);
        int res = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int find =0;
            if(nums[i]>=diff){
                find = nums[i] - diff;
            } else {
                find = nums[i] + p -diff;
            }
            if(map.containsKey(find)){
                int index = map.get(find);
                res = Math.min(res, i - index);
            }
            map.put(nums[i], i);
        }
        return res == nums.length ? -1 : res;
    }
}
