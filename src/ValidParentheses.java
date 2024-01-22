//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
//
//
//        Example 1:
//
//        Input: s = "()"
//        Output: true
//

import java.util.Stack;

class ValidParentheses {
    public boolean isValid(String s) {

        //Time Complexity - O(n)
        //Space Complexity - O(n)

        if (s.isEmpty() || s.length() == 1)
            return false;

        Stack<Character> brackets = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                brackets.add(ch);
            else {
                if (brackets.isEmpty())
                    return false;
                else if (ch == ')' &&  brackets.pop() != '(')
                    return false;
                else if (ch == '}' && brackets.pop() != '{')
                    return false;
                else if (ch == ']' && brackets.pop() != '[')
                    return false;
            }
        }
        return brackets.isEmpty();
    }
}