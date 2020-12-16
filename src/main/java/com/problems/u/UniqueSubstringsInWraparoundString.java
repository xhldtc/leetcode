package com.problems.u;

public class UniqueSubstringsInWraparoundString {

    //count代表以字母开头，最长的连续串长度，这样就代表以这个字母开头，最多有长度种子串，再统计所有字母即可
    public int findSubstringInWraproundString(String p) {
        if (p.length() == 0) {
            return 0;
        }
        int[] count = new int[26];
        char[] chs = p.toCharArray();
        char prev = chs[0];
        int start = 0;
        for (int i = 1; i < chs.length; i++) {
            char curr = chs[i];
            char next = (prev == 'z') ? 'a' : (char) (prev + 1);
            if (curr != next) {
                update(count, chs[start], i - start);
                start = i;
            }
            prev = curr;
        }
        update(count, chs[start], chs.length - start);
        int res = 0;
        for (int i = 0; i < count.length; i++) {
            res += count[i];
        }
        return res;
    }

    void update(int[] count, char ch, int len) {
        count[ch - 'a'] = Math.max(count[ch - 'a'], len);
        for (int i = 1; i < len; i++) {
            int curr = ch + (i % 26);
            if (curr > 'z') {
                curr -= 26;
            }
            count[curr - 'a'] = Math.max(count[curr - 'a'], len - i);
        }
    }

    public static void main(String[] args) {
        System.out.println(new UniqueSubstringsInWraparoundString().findSubstringInWraproundString("zab"));
    }
}
