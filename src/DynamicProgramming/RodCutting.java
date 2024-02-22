package DynamicProgramming;

//Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n.
// Determine the maximum value obtainable by cutting up the rod and selling the pieces.
// For example, if the length of the rod is 8 and the values of different pieces are given as the following,
// then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
//
//length   | 1   2   3   4   5   6   7   8
//        --------------------------------------------
//price    | 1   5   8   9  10  17  17  20
//And if the prices are as follows, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)


public class RodCutting {
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int[] rod = {1, 2, 3, 4, 5, 6, 7, 8};
        int size = 8;

        int[][] dp = new int[price.length + 1][size + 1];

        for (int i = 0; i <= price.length; i++) {
            for (int j = 0; j <= size; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (rod[i - 1] <= j) {
                    dp[i][j] = Math.max((price[i - 1] + (dp[i][j - rod[i - 1]])), (dp[i - 1][j]));
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[price.length][size]);
    }
}
