package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] ar = {2, 3, 4, 5, 7};
        int target = 7;
        int index = 0;
        List<List<Integer>> result = new ArrayList<>();
        findCombinationmSum(index, target, ar, result, new ArrayList<>());

        System.out.println(result);
    }

    private static void findCombinationmSum(int index, int target, int[] ar, List<List<Integer>> result, List<Integer> ds) {
        if (index == ar.length) {
            if (target == 0) {
                result.add(new ArrayList<>(ds));
                return;
            }
            return;
        }

        if (ar[index] <= target) {
            ds.add(ar[index]);
            findCombinationmSum(index, target - ar[index], ar, result, ds);
            ds.removeLast();
        }
        findCombinationmSum(index + 1, target, ar, result, ds);
    }
}
