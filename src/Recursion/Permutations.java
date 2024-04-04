package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    static int count = 0;

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4};
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] marked = new boolean[length];
        permute(nums, list, marked, ans);
        System.out.println(ans);
        System.out.println(count);
        permuteWithReducedSpace(0, nums, ans);
        System.out.println(ans);
        System.out.println(count);
    }

    private static void permuteWithReducedSpace(int index, int[] nums, List<List<Integer>> ans) {
        if (index == nums.length) {
            count++;
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
            ans.add(list);
        }

        for (int i = index; i < nums.length; i++) {
            swap(index, i, nums);
            permuteWithReducedSpace(index + 1, nums, ans);
            swap(index, i, nums);
        }
    }

    private static void swap(int index, int i, int[] nums) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }

    private static void permute(int[] nums, List<Integer> list, boolean[] marked, List<List<Integer>> ans) {
        if (list.size() == nums.length) {
            count++;
            ans.add(new ArrayList<>(list));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!marked[i]) {
                marked[i] = true;
                list.add(nums[i]);
                permute(nums, list, marked, ans);
                marked[i] = false;
                list.removeLast();
            }
        }
    }
}
