package com.problems.r;

/**
 * @author xhldtc on 2019-01-12.
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        String[] ss = s.trim().split("\\s+");
        if (ss.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            sb.append(ss[i]);
            if (i != 0) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAString().reverseWords("  the sky is  blue  "));
    }
}
