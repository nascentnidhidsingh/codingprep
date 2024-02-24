package DynamicProgramming;

//Input: S1 = “AGGTAB”, S2 = “AGGTAB”
//Output: 4
//Explanation: The longest subsequence which is present in both strings is “GTAB”.
//
//Input: S1 = “BD”, S2 = “ABCD”
//Output: 2
//Explanation: The longest subsequence which is present in both strings is “BD”.
//

import java.util.Arrays;

public class LCSMemoization {

    public static void main(String[] args) {
        String str1 = "AGGUYT";
        String str2 = "AGGTAB";
        char[] str1CharArray = str1.toCharArray();
        char[] str2CharArray = str2.toCharArray();
        int n = str1CharArray.length;
        int m = str2CharArray.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int[] subArray : dp) {
            Arrays.fill(subArray, -1);
        }

        System.out.println("Longest Common Subsequence" + " : " + lcs(str1CharArray, str2CharArray, n, m, dp));
    }

    private static int lcs(char[] str1CharArray, char[] str2CharArray, int n, int m, int[][] dp) {
        if (n == 0 || m == 0)
            return 0;
        if (dp[n][m] != -1)
            return dp[n][m];
        if (str1CharArray[n - 1] == str2CharArray[m - 1]) {
            return dp[n][m] = 1 + lcs(str1CharArray, str2CharArray, n - 1, m - 1, dp);
            //return dp[n][m];
        } else {
            dp[n][m] = Math.max((lcs(str1CharArray, str2CharArray, n - 1, m, dp)), (lcs(str1CharArray, str2CharArray, n, m - 1, dp)));
            return dp[n][m];
        }
    }
}
