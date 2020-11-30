package com.problems.p;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    Integer top = null;
    Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(!hasNext()){
            return null;
        }
        if(top == null){
            top = iterator.next();
        }
        return top;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(top!=null){
            Integer tmp = top;
            top = null;
            return tmp;
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return top != null || iterator.hasNext();
    }
}
