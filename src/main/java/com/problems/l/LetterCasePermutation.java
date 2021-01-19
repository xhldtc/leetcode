package com.problems.l;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    List<String> res = new ArrayList<>();
    char[] ch, src;

    public List<String> letterCasePermutation(String S) {
        ch = new char[S.length()];
        src = S.toCharArray();
        dfs(0);
        return res;
    }

    void dfs(int d) {
        if (d == ch.length) {
            res.add(new String(ch));
            return;
        }
        char c = src[d];
        if (c < '0' || c > '9') {
            int num = (c >= 'a' && c <= 'z') ? c - 'a' : c - 'A';
            ch[d] = (char) ('a' + num);
            dfs(d + 1);
            ch[d] = (char) ('A' + num);
            dfs(d + 1);
        } else {
            ch[d] = c;
            dfs(d + 1);
        }
    }
}
