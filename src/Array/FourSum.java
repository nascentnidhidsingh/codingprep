package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1, -1, 0, 0, 8, 2, -2};
        int target = 0;
        System.out.println(calculateFourSum(nums, target));
    }

    public static List<List<Integer>> calculateFourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < length; j++) {
                int start = j + 1;
                int end = length;
                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);
                        result.add(temp);
                        start++;
                        end--;
                        while (start < end && nums[start] == nums[start - 1]) start++;
                        while (start < end && nums[end] == nums[end + 1]) end--;
                    } else if (sum < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return result;
    }
}
