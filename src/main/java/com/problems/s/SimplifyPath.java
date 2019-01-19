package com.problems.s;

import java.util.LinkedList;

/**
 * @author xhldtc on 2019-01-15.
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        LinkedList<String> list = new LinkedList<>();
        StringBuilder curr = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            if (ch == '/') {
                if (curr.length() != 0) {
                    String s = curr.toString();
                    if (s.equals("..") && !list.isEmpty()) {
                        list.removeLast();
                    } else if (!s.equals("..")&& !s.equals(".")) {
                        list.addLast(curr.toString());
                    }
                    curr.delete(0, curr.length());
                }
            } else {
                curr.append(ch);
            }
        }
        if (curr.length() != 0) {
            String s = curr.toString();
            if (s.equals("..") && !list.isEmpty()) {
                list.removeLast();
            } else if (!s.equals("..")&& !s.equals(".")) {
                list.addLast(curr.toString());
            }
        }
        if (list.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append("/").append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath s = new SimplifyPath();
        System.out.println(s.simplifyPath("/home/"));
        System.out.println(s.simplifyPath("/home//foo/"));
        System.out.println(s.simplifyPath("/a/./b/../../c/"));
        System.out.println(s.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(s.simplifyPath("/a//b////c/d//././/.."));
        System.out.println(s.simplifyPath("/..."));
    }
}
