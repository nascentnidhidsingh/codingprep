package DynamicProgramming;

import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 8, 10};
        int sum = 99;
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];


        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0)
                    dp[i][j] = false;
                if (j == 0)
                    dp[i][j] = true;
            }
        }
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = ((dp[i - 1][j - arr[i - 1]]) || (dp[i - 1][j]));
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[arr.length][sum]);
    }
}
