package DynamicProgramming;

import java.util.Arrays;

public class PalindromePartitioningMemoization {
    public static void main(String[] args) {
        String str = "ababbbabbababa";
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        System.out.println(solve(str, 0, str.length() - 1, dp));
    }

    public static int solve(String str, int i, int j, int[][] dp) {
        int result = Integer.MAX_VALUE;
        if (i >= j)
            return 0;
        if (isPallindrome(str, i, j))
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        for (int k = i; k <= j - 1; k++) {
            int temp = solve(str, i, k, dp) + solve(str, k + 1, j, dp) + 1;
            result = Math.min(result, temp);
        }
        return dp[i][j] = result;
    }

    private static boolean isPallindrome(String str, int i, int j) {
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
