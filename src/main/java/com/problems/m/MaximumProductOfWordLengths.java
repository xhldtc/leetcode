package com.problems.m;

import java.util.HashSet;
import java.util.Set;

public class MaximumProductOfWordLengths {

    public int maxProduct(String[] words) {
        Word[] ws = new Word[words.length];
        for (int i = 0; i < ws.length; i++) {
            ws[i] = new Word(words[i].length(), words[i]);
        }
        int res = 0;
        for (int i = 0; i < ws.length; i++) {
            for (int j = i + 1; j < ws.length; j++) {
                if (!ws[i].overlap(ws[j])) {
                    res = Math.max(res, ws[i].len * ws[j].len);
                }
            }
        }
        return res;
    }

    static class Word {
        Set<Character> set;
        int len;

        Word(int len, String word) {
            this.set = new HashSet<>();
            this.len = len;
            for (int i = 0; i < word.length(); i++) {
                set.add(word.charAt(i));
            }
        }

        boolean overlap(Word w) {
            for (Character ch : set) {
                if (w.set.contains(ch)) {
                    return true;
                }
            }
            return false;
        }
    }
}
