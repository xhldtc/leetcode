package com.problems.w;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        Set<String> set = new HashSet<>(wordList);
        List<Node> queue = new LinkedList<>();
        queue.add(new Node(beginWord, 1));
        while (!queue.isEmpty()) {
            Node node = queue.remove(0);
            List<String> searched = new ArrayList<>();
            for (String word : set) {
                if (connect(word, node.word)) {
                    if (word.equals(endWord))
                        return node.depth + 1;
                    else {
                        queue.add(new Node(word, node.depth + 1));
                        searched.add(word);
                    }
                }
            }
            set.removeAll(searched);
        }
        return 0;
    }

    static class Node {
        String word;
        int depth;

        Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
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
        System.out.println(new WordLadder().ladderLength("qa", "sq", Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye")));
        System.out.println(new WordLadder().ladderLength("hit","cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
}
