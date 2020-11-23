package com.problems.f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length())
            return new ArrayList<>();
        int[] src = new int[26], count = new int[26];
        for (char ch : p.toCharArray()) {
            src[ch - 'a']++;
        }
        for (char ch : s.substring(0, p.length()).toCharArray()) {
            count[ch - 'a']++;
        }
        List<Integer> list = new ArrayList<>();
        if (Arrays.equals(src, count))
            list.add(0);

        for (int i = 1; i <= s.length() - p.length(); i++) {
            count[s.charAt(i - 1) - 'a']--;
            count[s.charAt(i + p.length() - 1) - 'a']++;
            if (Arrays.equals(src, count))
                list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new FindAllAnagramsInString().findAnagrams("cbaebabacd", "abc"));
    }
}
