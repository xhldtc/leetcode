package com.problems.p;

import java.util.LinkedList;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {

    public List<Integer> pathInZigZagTree(int label) {
        int base = 2, level = 1;
        while(label >= base) {
            base <<= 1;
            level++;
        }
        boolean order = (level & 1)==1;
        int start =  order ? base /2 : (base -1);
        int index = Math.abs(label - start);
        LinkedList<Integer> res = new LinkedList<>();
        for(int L = level;L >=1;L--) {
            res.addFirst(order ? (start + index) : (start - index));
            base >>= 1;
            index >>=1;
            order = !order;
            start = order ? base /2 : (base -1);
        }
        return res;
    }
}
