package com.leetcode.dp;

import java.util.Stack;

public class LongestValidParenthsis {

    public static void main(String... args) {
        //String input = ")((())(()))";
        String input = "(()()";
        LongestValidParenthsis obj = new LongestValidParenthsis();
        System.out.println(obj.longestValidParenthsis(input));

        System.out.println(longestValidParentheses(input));
    }

    private int longestValidParenthsis(String s) {

        int max = 0;
        int counter = 0;
        Stack<Character> stack = new Stack<>();

        if (s == null || s.length() == 0) {
            return 0;
        }

        char j = s.charAt(0);

        if (j == '(') {
            stack.push(j);
        }

        for (int i = 1; i < s.length(); i++) {
            j = s.charAt(i);
            if(j == '('){
                stack.push(j);
                if(s.charAt(i-1) == ')'){
                    max = counter;
                    counter = 0;
                }
            }else {
                stack.pop();
                counter++;
            }
        }

        if(stack.isEmpty()){
            return counter + max;
        }else {
            return max > counter ? max: counter;
        }
    }

    public static int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
