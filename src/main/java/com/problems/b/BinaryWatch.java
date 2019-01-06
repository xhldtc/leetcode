package com.problems.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xhldtc on 2019-01-06.
 */
public class BinaryWatch {

    private Map<Integer, List<String>> map = new HashMap<>();

    public BinaryWatch() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 63; j++) {
                String s = time(i, j);
                if (s != null) {
                    int num = countBits(i) + countBits(j);
                    if (!map.containsKey(num)) {
                        map.put(num, new ArrayList<>());
                    }
                    map.get(num).add(s);
                }
            }
        }
    }

    public List<String> readBinaryWatch(int num) {
        List<String> result = map.get(num);
        return result == null ? new ArrayList<>() : result;
    }

    private String time(int hour, int minute) {
        if (hour < 12 && minute < 60) {
            return hour + ":" + String.format("%02d", minute);
        }
        return null;
    }

    private int countBits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num & 1;
            num >>>= 1;
        }
        return sum;
    }
}
