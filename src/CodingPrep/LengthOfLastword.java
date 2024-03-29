package CodingPrep;//Given a string s consisting of words and spaces, return the length of the last word in the string.
//
//A word is a maximal
//        substring
//consisting of non-space characters only.
//
//
//
//        Example 1:
//
//Input: s = "Hello World"
//Output: 5
//Explanation: The last word is "World" with length 5.

class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        //Space complexity - O(n)
        //Time Complexity - O(1)
        String[] str = s.split(" ");
        int length = str.length;
        return str[length-1].length();
    }
}