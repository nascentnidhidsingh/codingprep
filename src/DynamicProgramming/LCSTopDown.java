package DynamicProgramming;

public class LCSTopDown {
    public static void main(String[] args) {
        String s = "ADFGBHJE";
        String t = "AAADSSFGBHJE";
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        System.out.println("Longest Common Subsequence : " + lcsDP(s, t, dp, s.length(), t.length()));
    }

    private static int lcsDP(String s, String t, int[][] dp, int n, int m) {
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= m; j++) {
//                if (i == 0 || j == 0)
//                    dp[i][j] = 0;
//            }
//        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s.charAt(n - 1) == t.charAt(m - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
