package com.problems.c;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xhldtc on 24/11/2018.
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
