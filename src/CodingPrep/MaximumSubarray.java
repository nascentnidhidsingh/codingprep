package CodingPrep;//Given an integer array nums, find the
//subarray
//with the largest sum, and return its sum.
//
//
//
//Example 1:
//
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: The subarray [4,-1,2,1] has the largest sum 6.

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {

        int max_sum = Integer.MIN_VALUE;
        int curr_sum = 0;

        for (int i : nums) {
            curr_sum += i;
            if (curr_sum > max_sum) {
                max_sum = curr_sum;
            }
            if (curr_sum < 0) {
                curr_sum = 0;
            }
        }
        return max_sum;
    }
}
