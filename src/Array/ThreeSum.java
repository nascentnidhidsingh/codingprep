package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Three sum with no duplicates
public class ThreeSum {
    public static void main(String[] args) {
        int[] ar = {1, 0, 1, 2, -1, -4};
        int target = 0;
        List<List<Integer>> result = new ArrayList<>();
        threeSum(ar, target, result);
        System.out.println(result);
    }

    private static void threeSum(int[] ar, int target, List<List<Integer>> result) {

        int end = ar.length - 1;
        Arrays.sort(ar);
        for (int i = 0; i < end; i++) {
            int twoSum = target - ar[i];
            int start = i + 1;
            while (start < end) {
                int sum = ar[start] + ar[end];
                if (twoSum == sum) {
                    result.add(Arrays.asList(ar[i], ar[start], ar[end]));
                    while (ar[start + 1] == ar[start]) {
                        start++;
                    }
                    while (ar[end - 1] == ar[end]) {
                        end--;
                    }
                    start++;
                    end--;
                } else if (twoSum > sum) {
                    start++;
                } else {
                    end--;
                }
            }
        }
    }
}
