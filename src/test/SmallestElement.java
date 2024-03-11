package test;

import java.util.Stack;

public class SmallestElement {
    public static void main(String[] args) {
        String str = "10200";
        int k = 1;
        System.out.println(findSmallestElement(str, k));
    }

    private static String findSmallestElement(String str, int k) {
        Stack<Character> stack = new Stack<>();
        if (k > str.length())
            return "";

        for (int i = 0; i < str.length(); i++) {
            while (!stack.isEmpty() && stack.peek() > str.charAt(i) && k != 0) {
                stack.pop();
                k--;
            }
            if (!stack.isEmpty() || str.charAt(i) != '0') {
                stack.push(str.charAt(i));
            }
        }
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            s.append(stack.pop());
            k--;
        }
        return s.reverse().toString();
    }
}
