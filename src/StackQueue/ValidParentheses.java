package StackQueue;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        char[] braces = {'(', '{', '[', ']'};
        char[] braces_testcase = {'(', '{', '}', ')'};
        System.out.println("The input has ValidParentheses : " + checkValidity(braces_testcase));
    }

    private static boolean checkValidity(char[] braces) {
        Stack<Character> stack = new Stack<>();
        for (char ch : braces) {
            if (!stack.isEmpty() && ((stack.peek() == '(' && ch == ')') || (stack.peek() == '{' && ch == '}') || (stack.peek() == '[' && ch == ']'))) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
