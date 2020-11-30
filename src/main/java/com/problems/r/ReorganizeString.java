package com.problems.r;

import java.util.ArrayList;
import java.util.List;

public class ReorganizeString {

    public String reorganizeString(String S) {
        int[] count = new int[26];
        for (char ch : S.toCharArray()) {
            count[ch - 'a']++;
        }
        List<CharCount> list = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                list.add(new CharCount((char) (i + 'a'), count[i]));
            }
        }
        list.sort((c1, c2) -> Integer.compare(c2.count, c1.count));
        int maxCharCount = list.get(0).count;
        int remain = 0;
        for (int i = 1; i < list.size(); i++) {
            remain += list.get(i).count;
        }
        if (remain < maxCharCount - 1) {
            return "";
        }
        List<StringBuilder> sbs = new ArrayList<>(maxCharCount);
        for (int i = 0; i < maxCharCount; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(0).ch);
            sbs.add(sb);
        }
        int index = 0;
        for (int i = 1; i < list.size(); i++) {
            CharCount cc = list.get(i);
            for (int j = 0; j < cc.count; j++) {
                int ind = index % maxCharCount;
                index++;
                sbs.get(ind).append(cc.ch);
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : sbs) {
            res.append(sb);
        }
        return res.toString();
    }

    static class CharCount {
        char ch;
        int count;

        public CharCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
