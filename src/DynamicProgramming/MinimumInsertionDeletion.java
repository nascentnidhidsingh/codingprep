package DynamicProgramming;

public class MinimumInsertionDeletion {
    public static void main(String[] args) {
        String s = "heap";
        String t = "pea";
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        int lcs = lcs(s, t, s.length(), t.length(), dp);
        System.out.println("Number of Insertions : " + (t.length() - lcs));
        System.out.println("Number of Deletions : " + (s.length() - lcs));
    }

    public static int lcs(String s, String t, int m, int n, int[][] dp) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max((dp[i - 1][j]), (dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
    }
}
