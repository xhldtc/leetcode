package com.problems.c;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Candy {

    public int candy(int[] r) {
        int[] res = new int[r.length];
        int start = -1;
        for (int i = 0; i < r.length; i++) {
            if (i == 0 && r[i] == r[i + 1]) {
                res[i] = 1;
            } else if (i == r.length - 1 && r[i] == r[i - 1]) {
                res[i] = 1;
            } else if (i > 0 && i < r.length - 1 && r[i] == r[i - 1] && r[i] == r[i + 1]) {
                res[i] = 1;
            }
            if (start == -1 && res[i] == 0) {
                start = i;
            }
        }
        if (start == -1) {
            return r.length;
        }
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<Integer> tmp = new LinkedList<>();
        tmp.add(start);
        int prev = start;
        Boolean inc = null;
        for (int i = start + 1; i < r.length; i++) {
            if (res[i] != 0) {
                continue;
            }
            if (inc == null) {
                if (r[i] > r[prev]) {
                    inc = true;
                    tmp.add(i);
                } else {
                    inc = false;
                    tmp.addFirst(i);
                }
            } else {
                if (inc) {
                    if (r[i] > r[prev]) {
                        tmp.add(i);
                    } else if (r[i] < r[prev]) {
                        list.add(tmp);
                        tmp = new LinkedList<>();
                        tmp.add(i);
                        tmp.add(prev);
                        inc = false;
                    } else {
                        list.add(tmp);
                        tmp = new LinkedList<>();
                        tmp.add(i);
                        inc = null;
                    }
                } else {
                    if (r[i] < r[prev]) {
                        tmp.addFirst(i);
                    } else if (r[i] > r[prev]) {
                        list.add(tmp);
                        tmp = new LinkedList<>();
                        tmp.add(prev);
                        tmp.add(i);
                        inc = true;
                    } else {
                        list.add(tmp);
                        tmp = new LinkedList<>();
                        tmp.add(i);
                        inc = null;
                    }
                }
            }
            prev = i;
        }
        list.add(tmp);
        for (List<Integer> lst : list) {
            for (int i = 0; i < lst.size(); i++) {
                int index = lst.get(i);
                res[index] = Math.max(res[index], i + 1);
            }
        }
        int total = 0;
        for (int i = 0; i < res.length; i++) {
            total += res[i];
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new Candy().candy(new int[]{10, 10, 10, 10, 10, 10}));
    }
}
