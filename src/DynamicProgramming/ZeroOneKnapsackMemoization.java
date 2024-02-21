package DynamicProgramming;

import java.util.Arrays;

public class ZeroOneKnapsackMemoization {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4, 5};
        int[] value = {1, 4, 5, 7};
        int capacity = 7;
        int[][] dp = new int[weight.length + 1][capacity + 1];
        for (int[] subArray : dp) {
            Arrays.fill(subArray, -1);
        }
        int maxProfit = knapsackMemoization(weight, value, capacity, weight.length, dp);
        System.out.println(maxProfit);

    }

    private static int knapsackMemoization(int[] weight, int[] value, int w, int n, int[][] dp) {
        if (w == 0 || n == 0)
            return 0;
        if (dp[n][w] != -1)
            return dp[w][n];
        if (weight[n - 1] <= w) {
            dp[n][w] = Math.max((value[n - 1] + knapsackMemoization(weight, value, w - weight[n - 1], n - 1, dp)), knapsackMemoization(weight, value, w, n - 1, dp));
            return dp[n][w];
        } else {
            dp[n][w] = knapsackMemoization(weight, value, w, n - 1, dp);
            return dp[w][n];
        }
    }
}
