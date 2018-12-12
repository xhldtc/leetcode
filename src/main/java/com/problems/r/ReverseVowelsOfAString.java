package com.problems.r;

import java.util.Arrays;
import java.util.List;

/**
 * @author xhldtc on 12/12/2018.
 */
public class ReverseVowelsOfAString {

    private List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    private boolean isVowel(char ch) {
        return vowels.contains(ch);
    }

    public String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        char[] array = s.toCharArray();
        while (left < right) {
            if (isVowel(array[left]) && isVowel(array[right])) {
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            } else if (isVowel(array[left])) {
                right--;
            } else if (isVowel(array[right])) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        return new String(array);
    }
}
