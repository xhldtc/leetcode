package com.problems.f;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xhldtc on 2019-01-01.
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int[] index = new int[26];
        for (int i = 0; i < index.length; i++) {
            index[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            int ind = ch - 'a';
            count[ind]++;
            if (index[ind] == -1) {
                index[ind] = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                list.add(index[i]);
            }
        }
        return list.stream().mapToInt(i -> i).min().orElse(-1);
    }
}
