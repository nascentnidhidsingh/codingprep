package DynamicProgramming;

public class MinimumDeletionForLPS {
    public static void main(String[] args) {
        String s = "MADNAM";
        String t = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        final int i = lps(s, t, s.length(), t.length(), dp);
        System.out.println("LPS length is : " + i);
        System.out.println("Minimum deletion required to make LPS is : " + (s.length() - i));
    }

    public static int lps(String s, String t, int m, int n, int[][] dp) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
