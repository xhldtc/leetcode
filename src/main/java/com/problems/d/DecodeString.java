package com.problems.d;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        boolean prevInteger = false;
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                k = k * 10 + ch - '0';
                prevInteger = true;
            } else {
                if (prevInteger) {
                    stack.push(String.valueOf(k));
                    prevInteger = false;
                    k = 0;
                }
                if ((ch >= 'a' && ch <= 'z') || ch == '[') {
                    stack.push(String.valueOf(ch));
                } else if (ch == ']') {
                    StringBuilder curr = new StringBuilder();
                    while (!stack.peek().equals("[")) {
                        curr.insert(0, stack.pop());
                    }
                    stack.pop();
                    int repeat = Integer.parseInt(stack.pop());
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < repeat; j++)
                        sb.append(curr);
                    stack.push(sb.toString());
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("abc13[cd]xyz"));
    }
}
