package com.problems.f;

import com.structure.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();
        build(nestedList, list);
        iterator = list.iterator();
    }

    void build(List<NestedInteger> nestedList, List<Integer> list) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger())
                list.add(ni.getInteger());
            else
                build(ni.getList(), list);
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}
