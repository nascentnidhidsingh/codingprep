package DynamicProgramming;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String s = "ABRCDFGADBERCZXCD";
        String t = "ABRCDFGADBERCZXCD";
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        System.out.println(lrs(s, t, m, n, dp));

    }

    private static int lrs(String s, String t, int m, int n, int[][] dp) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s.charAt(i - 1) == t.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }


}
