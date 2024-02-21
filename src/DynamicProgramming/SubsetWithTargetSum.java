package DynamicProgramming;

//You are given an integer array nums and an integer target.
//
//You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
//
//For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
//Return the number of different expressions that you can build, which evaluates to target.
//
//
//
//        Example 1:
//
//Input: nums = [1,1,1,1,1], target = 3
//Output: 5
//Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.

public class SubsetWithTargetSum {

    public static void main(String[] args) {
        int[] ar = {1, 1, 2, 3};
        System.out.println(findTargetSumWays(ar, 1));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums)
            sum += i;

        if ((sum < target) || ((sum - target) % 2 == 1))
            return 0;

        int diff = (sum - target) / 2;
        int[][] dp = new int[nums.length + 1][diff + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= diff; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = ((dp[i - 1][j - nums[i - 1]]) + (dp[i - 1][j]));
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][diff];

    }
}
