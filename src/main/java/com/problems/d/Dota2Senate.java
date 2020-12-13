package com.problems.d;

import java.util.Deque;
import java.util.LinkedList;

public class Dota2Senate {

    public String predictPartyVictory(String senate) {
        Deque<Integer> R = new LinkedList<>();
        Deque<Integer> D = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            char ch = senate.charAt(i);
            if (ch == 'R')
                R.offer(i);
            else
                D.offer(i);
        }
        //每个while循环是一轮投票
        while (!R.isEmpty() && !D.isEmpty()) {
            int len = Math.min(R.size(), D.size());
            int remain = Math.abs(R.size() - D.size());
            Deque<Integer> win = R.size() < D.size() ? D : R;
            Deque<Integer> lose = R.size() < D.size() ? R : D;
            //以人数少的那方为基准投票，每一对做对比，在前的禁用在后的
            for (int i = 0; i < len; i++) {
                int r = R.poll();
                int d = D.poll();
                if (r < d) {
                    R.offer(r);
                } else {
                    D.offer(d);
                }
            }
            //如果某一方人数多，那么它就可以从起点开始禁用，为下一轮打基础，此时人少方无力反抗，因为前面人数相同时对抗已经结束了
            for (int i = 0; i < remain; i++) {
                if (R.isEmpty() || D.isEmpty()) {
                    break;
                }
                win.offer(win.poll());
                lose.poll();
            }
        }
        return R.isEmpty() ? "Dire" : "Radiant";
    }
}
