package Recursion;

import java.util.*;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] ar = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        int index = 0;
        Arrays.sort(ar);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        combinationSumII(index, target, ar, ans, ds);
        System.out.println(ans);
    }

    private static void combinationSumII(int index, int target, int[] ar, List<List<Integer>> ans, List<Integer> ds) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < ar.length; i++) {
            if (ar[i] > target) break;
            if (i > index && ar[i] == ar[i - 1]) continue;

            ds.add(ar[i]);
            combinationSumII(i + 1, target - ar[i], ar, ans, ds);
            ds.removeLast();
        }
    }
}

