package DynamicProgramming;

public class PrintLCSTopDown {
    public static void main(String[] args) {
        String str1 = "AGGUYT";
        String str2 = "AGGTAB";
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        System.out.println(printLCS(c1, c2, str1.length(), str2.length(), dp));
    }

    private static StringBuilder printLCS(char[] str1, char[] str2, int m, int n, int[][] dp) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder str = new StringBuilder();
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (str1[i - 1] == str2[j - 1]) {
                str.append(str2[i - 1]);
                //System.out.println(str1[i - 1]);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return str.reverse();
    }
}
