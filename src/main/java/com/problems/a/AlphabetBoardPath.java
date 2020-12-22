package com.problems.a;

import java.util.HashMap;
import java.util.Map;

public class AlphabetBoardPath {

    public String alphabetBoardPath(String target) {
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) (i + 'a'), new int[]{i / 5, i % 5});
        }
        int[] prev = new int[]{0, 0};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            int[] curr = map.get(ch);
            if (prev[0] > curr[0] && prev[1] < curr[1]) {
                go(sb, 'U', prev[0] - curr[0]);
                go(sb, 'R', curr[1] - prev[1]);
            } else if (prev[0] < curr[0] && prev[1] > curr[1]) {
                go(sb, 'L', prev[1] - curr[1]);
                go(sb, 'D', curr[0] - prev[0]);
            } else {
                char c1 = prev[0] > curr[0] ? 'U' : 'D';
                char c2 = prev[1] > curr[1] ? 'L' : 'R';
                go(sb, c1, Math.abs(prev[0] - curr[0]));
                go(sb, c2, Math.abs(prev[1] - curr[1]));
            }
            sb.append('!');
            prev = curr;
        }
        return sb.toString();
    }

    void go(StringBuilder sb, char ch, int c) {
        for (int i = 0; i < c; i++) {
            sb.append(ch);
        }
    }
}
