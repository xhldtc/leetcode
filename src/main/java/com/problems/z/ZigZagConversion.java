package com.problems.z;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() <= numRows){
            return s;
        }
        List<List<Character>> list = new ArrayList<>(numRows);
        for(int i=0;i<numRows;i++)
            list.add(new ArrayList<>());

        boolean down = true;
        int index = 0;
        for(char ch: s.toCharArray()){
            if(index ==0){
                down = true;
            }
            if(index == numRows -1){
                down = false;
            }
            List<Character> curr = list.get(index);
            curr.add(ch);
            if(down){
                index++;
            } else {
                index--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++){
            for(char ch: list.get(i)){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
