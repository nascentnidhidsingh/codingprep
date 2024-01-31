package CodingPrep;

//Given an integer x, return true if x is a
//        palindrome
//, and false otherwise.
//
//
//
//        Example 1:
//
//Input: x = 121
//Output: true
//Explanation: 121 reads as 121 from left to right and from right to left.
class IsPallindrome {
    public boolean isPalindrome(int x) {
        //Time complexity-O(n)
        //Space Complexity-O(1)
        if (x < 0)
            return false;

        int reverse = 0;
        int dup = x;
        while (dup > 0) {
            int mod = dup%10;
            reverse = reverse*10+mod;
            dup = (dup-mod)/10;
        }
        return x == reverse ? true : false;
    }
}
