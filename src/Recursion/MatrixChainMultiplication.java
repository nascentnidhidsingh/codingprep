package Recursion;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] ar = {40, 20, 30, 10, 30};
        System.out.println(solve(ar, 1, ar.length - 1));
    }

    private static int solve(int[] ar, int i, int j) {
        if (i >= j) {
            return 0;
        }
        int result = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int temp = solve(ar, i, k) + solve(ar, k + 1, j) + (ar[i - 1] * ar[k] * ar[j]);
            result = Math.min(result, temp);
        }
        return result;
    }
}
