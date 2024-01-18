//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//
//Given a string s, return true if it is a palindrome, or false otherwise.
//
//
//
//        Example 1:
//
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.

class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;

        if(s.isEmpty()){
            return true;
        }

        while (start <= end) {
            char startCh = s.charAt(start);
            char endCh = s.charAt(end);
            if (!Character.isLetterOrDigit(startCh))
                start++;
            else if(!Character.isLetterOrDigit(endCh))
                end--;
            else {
                if(Character.toLowerCase(startCh) != Character.toLowerCase(endCh))
                    return false;

                start++;
                end--;
            }
        }
        return true;
    }
}