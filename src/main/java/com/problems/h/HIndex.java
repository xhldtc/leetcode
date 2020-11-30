package com.problems.h;

import java.util.Arrays;

public class HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        if (citations.length == 0)
            return 0;
        for (int h = citations.length; h >= 0; h--) {
            if (h == citations.length) {
                if (citations[0] >= h)
                    return h;
            } else if (h == 0) {
                if (citations[citations.length - 1] == 0)
                    return 0;
            } else {
                if (citations[citations.length - h] >= h && citations[citations.length - h - 1] <= h)
                    return h;
            }
        }
        return -1;
    }
}
