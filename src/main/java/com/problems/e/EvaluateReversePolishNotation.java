package com.problems.e;

import java.util.Stack;

/**
 * @author xhldtc on 2019-02-27.
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("*".equals(token)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("-".equals(token)) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first - second);
            } else if ("/".equals(token)) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first / second);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
