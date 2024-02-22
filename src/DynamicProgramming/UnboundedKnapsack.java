package DynamicProgramming;

//
//Given a knapsack weight W and a set of n items with certain value vali and weight wti, we need to calculate the maximum amount that could make up this quantity exactly. This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.
//
//        Note: N is always positive i.e greater than zero
//
//Examples:
//
//Input : W = 100
//val[]  = {1, 30}
//wt[] = {1, 50}
//Output : 100
//There are many ways to fill knapsack.
//1) 2 instances of 50 unit weight item.
//2) 100 instances of 1 unit weight item.
//3) 1 instance of 50 unit weight item and 50
//instances of 1 unit weight items.
//We get maximum value with option 2.
//
//Input : W = 8
//val[] = {10, 40, 50, 70}
//wt[]  = {1, 3, 4, 5}
//Output : 110
//We get maximum value with one unit of
//weight 5 and one unit of weight 3.
public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] weight = {1, 50};
        int[] value = {1, 30};
        int capacity = 100;
        int[][] dp = new int[weight.length + 1][capacity + 1];

        System.out.println(unboundedKnapsack(weight, value, capacity, weight.length, dp));
    }

    private static int unboundedKnapsack(int[] weight, int[] value, int capacity, int length, int[][] dp) {

        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(((value[i - 1] + dp[i][j - weight[i - 1]])), (dp[i - 1][j]));
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[length][capacity];
    }
}
