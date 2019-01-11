package com.problems.m;


import com.structure.Interval;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xhldtc on 2019-01-11.
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return intervals;
        }
        intervals.sort(Comparator.comparingInt(i -> i.start));
        LinkedList<Interval> result = new LinkedList<>();
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            Interval last = result.getLast();
            if (curr.start <= last.end) {
                result.removeLast();
                result.add(new Interval(last.start, Math.max(last.end, curr.end)));
            } else {
                result.add(curr);
            }
        }
        return result;
    }
}
