package DynamicProgramming;

public class PrintSCS {
    public static void main(String[] args) {
        String s = "ABCDEF";
        String t = "ADFBDEF";
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        System.out.println(scs(s, t, m, n, dp));
    }

    private static StringBuilder scs(String s, String t, int m, int n, int[][] dp) {
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
        int i = m;
        int j = n;
        StringBuilder st = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                st.append(s.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                st.append(s.charAt(i - 1));
                i--;
            } else {
                st.append(t.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            st.append(s.charAt(i));
            i--;
        }
        while (j > 0) {
            st.append(t.charAt(j));
            j--;
        }
        return st.reverse();
    }
}
