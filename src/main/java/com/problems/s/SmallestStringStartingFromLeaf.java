package com.problems.s;

import com.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SmallestStringStartingFromLeaf {

    String res = "~";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new ArrayList<>(8500));
        return res;
    }

    void dfs(TreeNode node, List<Character> list) {
        list.add((char) (node.val + 'a'));
        if (node.left == null && node.right == null) {
            String tmp = getString(list);
            if (tmp.compareTo(res) < 0) {
                res = tmp;
            }
        } else {
            if (node.left != null) {
                dfs(node.left, list);
            }
            if (node.right != null) {
                dfs(node.right, list);
            }
        }
        list.remove(list.size() - 1);
    }

    String getString(List<Character> list) {
        char[] chs = new char[list.size()];
        int index = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            chs[index++] = list.get(i);
        }
        return new String(chs);
    }
}
