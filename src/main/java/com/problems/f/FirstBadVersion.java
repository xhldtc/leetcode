package com.problems.f;

import com.structure.VersionControl;

/**
 * @author xhldtc on 25/11/2018.
 */
public class FirstBadVersion extends VersionControl {

    public int firstBadVersion(int n) {
        if (isBadVersion(1)) {
            return 1;
        }
        int left = 1, right = n;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return isBadVersion(left) ? left : right;
    }
}
