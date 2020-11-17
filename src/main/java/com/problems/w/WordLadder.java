package com.problems.w;

import java.util.Arrays;
import java.util.List;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        boolean[] flag = new boolean[wordList.size()];
        int[] res = new int[1];
        dfs(1, beginWord, endWord, wordList, flag, res);
        return res[0];
    }

    private void dfs(int depth, String curr, String endWord, List<String> wordList, boolean[] flag, int[] res) {
        if (curr.equals(endWord)) {
            if (res[0] == 0)
                res[0] = depth;
            else
                res[0] = Math.min(res[0], depth);
            return;
        }

        for (int i = 0; i < wordList.size(); i++) {
            if (flag[i])
                continue;
            if (connect(curr, wordList.get(i))) {
                flag[i] = true;
                dfs(depth + 1, wordList.get(i), endWord, wordList, flag, res);
                flag[i] = false;
            }
        }
    }

    private boolean connect(String s, String t) {
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (!flag)
                    flag = true;
                else
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new WordLadder().ladderLength("qa", "sq", Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye")));
    }
}
