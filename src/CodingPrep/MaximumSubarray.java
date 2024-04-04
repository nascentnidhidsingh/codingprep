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
    public static int maxSubArray(int[] nums) {

        int max_sum = Integer.MIN_VALUE;
        int curr_sum = 0;
        int start = -1;
        int ansStart = -1;
        int ansEnd = -1;
        for (int i = 0; i < nums.length; i++) {
            if (curr_sum == 0) {
                start = i;
            }

            curr_sum += nums[i];
            if (curr_sum > max_sum) {
                max_sum = curr_sum;
                ansStart = start;
                ansEnd = i;
            }
            if (curr_sum < 0) {
                curr_sum = 0;
            }
        }
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return max_sum;
    }

    public static void main(String[] args) {
        int[] ar = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(ar));
    }
}
