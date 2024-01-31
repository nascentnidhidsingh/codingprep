package CodingPrep;//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//You must write an algorithm that runs in O(n) time and without using the division operation.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,4]
//Output: [24,12,8,6]

class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        //Time Complexity - O(n)
        //Space Complexity - O(n)
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int[] output = new int[nums.length];

        left[0] = 1;
        right[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            output[i] = left[i] * right[i];
        }

        return output;

    }
}
