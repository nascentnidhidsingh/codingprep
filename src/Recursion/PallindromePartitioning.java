package Recursion;

import javax.swing.plaf.PanelUI;

public class PallindromePartitioning {
    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println(solve(str, 0, str.length() - 1));
    }

    public static int solve(String str, int i, int j) {
        if (i >= j || isPallindrome(str, i, j)) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int temp = solve(str, i, k) + solve(str, k + 1, j) + 1;
            min = Math.min(min, temp);
        }
        return min;
    }

    public static boolean isPallindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
