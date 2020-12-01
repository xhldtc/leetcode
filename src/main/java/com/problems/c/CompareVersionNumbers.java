package com.problems.c;

public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
        int len = Math.max(v1.length, v2.length);
        for (int i = 0; i < len; i++) {
            int vv1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int vv2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (vv1 < vv2) {
                return -1;
            } else if (vv1 > vv2) {
                return 1;
            }
        }
        return 0;
    }
}
