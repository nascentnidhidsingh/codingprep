package DynamicProgramming;

public class CountSubsetsWithGivenDifference {
    public static void main(String[] args) {
        int[] ar = {1, 1, 2, 3};
        int diff = 1;
        int sum = 0;
        for (int i : ar)
            sum += i;
        int target = (sum + diff) / 2;

        int[][] dp = new int[ar.length + 1][target + 1];

        for (int i = 0; i <= ar.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (i == 0)
                    dp[i][j] = 0;
                if (j == 0)
                    dp[i][j] = 1;
            }
        }
        for (int i = 1; i <= ar.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (ar[i - 1] <= j) {
                    dp[i][j] = ((dp[i - 1][j - ar[i - 1]]) + (dp[i - 1][j]));
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[ar.length][target]);
    }
}
