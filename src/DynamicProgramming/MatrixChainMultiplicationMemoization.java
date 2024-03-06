package DynamicProgramming;

import java.util.Arrays;

public class MatrixChainMultiplicationMemoization {
    public static void main(String[] args) {
        int[] ar = {40, 20, 30, 10, 30};
        int[][] dp = new int[ar.length + 1][ar.length + 1];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        System.out.println(solve(ar, 1, ar.length - 1, dp));
    }

    public static int solve(int[] ar, int i, int j, int[][] dp) {
        if (i >= j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int res = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = solve(ar, i, k, dp) + solve(ar, k + 1, j, dp) + (ar[i - 1] * ar[k] * ar[j]);
            res = Math.min(res, temp);
        }
        return dp[i][j] = res;
    }
}
