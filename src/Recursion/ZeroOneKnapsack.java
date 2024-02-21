package Recursion;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4, 5};
        int[] value = {1, 4, 5, 7};
        int capacity = 7;
        int maxProfit = knapsack(weight, value, capacity, weight.length);
        System.out.println(maxProfit);
    }

    private static int knapsack(int[] weight, int[] value, int w, int n) {
        if (w == 0 || n == 0)
            return 0;
        if (weight[n - 1] <= w) {
            return Math.max((value[n - 1] + knapsack(weight, value, w - weight[n - 1], n - 1)), knapsack(weight, value, w, n - 1));
        } else
            return knapsack(weight, value, w, n - 1);
    }
}
