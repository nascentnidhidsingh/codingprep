package DynamicProgramming;

class ShortestCommonSupersequence {

    public static void main(String[] args) {
        String str1 = "ADFGBHJE";
        String str2 = "AAADSSFGBHJE";

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int m = str1.length();
        int n = str2.length();
        int lcs = longestCommonSubsequence(str1, str2, m, n, dp);
        System.out.println((m + n - lcs));
    }

    public static int longestCommonSubsequence(String str1, String str2, int m, int n, int[][] dp) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max((dp[i - 1][j]), (dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
    }
}