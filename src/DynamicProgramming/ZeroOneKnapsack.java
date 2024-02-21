package DynamicProgramming;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4, 5};
        int[] value = {1, 3, 5, 7};
        int capacity = 7;
        int[][] dp = new int[weight.length + 1][capacity + 1];
        System.out.println("The maximum profit is : " + knapsackDp(weight, value, capacity, dp, weight.length));
    }

    private static int knapsackDp(int[] weight, int[] value, int capacity, int[][] dp, int n) {

        for (int i = 0; i <= weight.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max((value[i - 1] + (dp[i - 1][j - weight[i - 1]])), dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][capacity];
    }
}
