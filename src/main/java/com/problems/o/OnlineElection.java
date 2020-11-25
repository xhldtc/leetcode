package com.problems.o;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OnlineElection {

    int[] times, winner;

    public OnlineElection(int[] persons, int[] times) {
        Map<Integer, Integer> count = new HashMap<>();
        int[] winner = new int[times.length];
        int maxVote = 0;
        for (int i = 0; i < times.length; i++) {
            int person = persons[i];
            count.merge(person, 1, Integer::sum);
            int vote = count.get(person);
            if (vote >= maxVote) {
                maxVote = vote;
                winner[i] = person;
            } else
                winner[i] = winner[i - 1];
        }
        this.times = times;
        this.winner = winner;
    }

    public int q(int t) {
        int search = Arrays.binarySearch(times, t);
        if (search >= 0)
            return winner[search];
        else
            return winner[-search - 2];
    }

    public static void main(String[] args) {
        OnlineElection o = new OnlineElection(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        System.out.println(o.q(3));
        System.out.println(o.q(12));
        System.out.println(o.q(25));
        System.out.println(o.q(15));
        System.out.println(o.q(24));
        System.out.println(o.q(8));
    }
}
