package com.problems.w;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {
            String curr = s.substring(0, i);
            for (String t : wordDict) {
                if (curr.endsWith(t) && dp[curr.length() - t.length()]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }
}
