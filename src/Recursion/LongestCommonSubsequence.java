package Recursion;

//Input: S1 = “AGGTAB”, S2 = “AGGTAB”
//Output: 4
//Explanation: The longest subsequence which is present in both strings is “GTAB”.
//
//Input: S1 = “BD”, S2 = “ABCD”
//Output: 2
//Explanation: The longest subsequence which is present in both strings is “BD”.
//

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "AGGTB";
        char[] str1CharArray = str1.toCharArray();
        char[] str2CharArray = str2.toCharArray();
        int n = str1CharArray.length;
        int m = str2CharArray.length;

        System.out.println("Longest Common Subsequence" + " : " + lcs(str1CharArray, str2CharArray, n, m));
    }

    private static int lcs(char[] str1CharArray, char[] str2CharArray, int n, int m) {
        if (n == 0 || m == 0)
            return 0;
        if (str1CharArray[n - 1] == str2CharArray[m - 1]) {
            return 1 + lcs(str1CharArray, str2CharArray, n - 1, m - 1);
        } else
            return Math.max((lcs(str1CharArray, str2CharArray, n - 1, m)), (lcs(str1CharArray, str2CharArray, n, m - 1)));
    }
}
