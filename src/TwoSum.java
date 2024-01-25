import java.util.HashMap;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.
//
//
//
//        Example 1:
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //Time Complexity - O(n)
        //Space Complexity - O(n)
        int[] output = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                output[0] =map.get(diff);
                output[1] = i;
            } else {
                map.put(nums[i],i);
            }
        }
        return output;
    }
}