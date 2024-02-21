package DynamicProgramming;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] ar = {1, 5, 4, 11};
        int n = ar.length;

        int sum = 0;
        for (int i : ar) {
            sum += i;
        }
        if (sum % 2 != 0) {
            System.out.println("No partition possible");
            return;
        }
        int x = sum / 2;
        boolean[][] dp = new boolean[n + 1][x + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= x; j++) {
                if (i == 0)
                    dp[i][j] = false;
                if (j == 0)
                    dp[i][j] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                if (ar[i - 1] <= j) {
                    dp[i][j] = ((dp[i - 1][j - ar[i - 1]]) || (dp[i - 1][j]));
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n][sum / 2]);
    }
}
