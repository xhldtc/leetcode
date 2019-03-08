package com.problems.b;

import java.util.LinkedList;

/**
 * @author xhldtc on 2019-03-08.
 */
public class BasicCalculatorII {

    public int calculate(String s) {
        LinkedList<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        String prevOp = null;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                help(prevOp, list, sb);
                sb.delete(0, sb.length());
                String op = String.valueOf(c);
                list.add(op);
                prevOp = op;
            } else {
                sb.append(c);
            }
        }
        help(prevOp, list, sb);
        while (list.size() > 1) {
            int first = Integer.valueOf(list.removeFirst());
            String op = list.removeFirst();
            int second = Integer.valueOf(list.removeFirst());
            if ("+".equals(op)) {
                list.addFirst(String.valueOf(first + second));
            } else {
                list.addFirst(String.valueOf(first - second));
            }
        }
        return Integer.valueOf(list.get(0));
    }

    private void help(String prevOp, LinkedList<String> list, StringBuilder sb) {
        if ("*".equals(prevOp) || "/".equals(prevOp)) {
            int second = Integer.valueOf(sb.toString());
            list.removeLast();
            int first = Integer.valueOf(list.removeLast());
            if ("*".equals(prevOp)) {
                list.add(String.valueOf(first * second));
            } else {
                list.add(String.valueOf(first / second));
            }
        } else {
            list.add(sb.toString());
        }
    }

    public static void main(String[] args) {
        int aa = new BasicCalculatorII().calculate(" 3 / 2 ");
        System.out.println(aa);
    }
}
