package DynamicProgramming;

public class CoinChangeMaximumNumberOfWays {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3};
        int target = 5;
        int[][] dp = new int[ar.length + 1][target + 1];

        for (int i = 0; i <= ar.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (i == 0)
                    dp[i][j] = 0;
                else if (j == 0)
                    dp[i][j] = 1;
                else if (ar[i - 1] <= j) {
                    dp[i][j] = ((dp[i - 1][j]) + (dp[i][j - ar[i - 1]]));
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println("number of ways : " + dp[ar.length][target]);
    }
}
