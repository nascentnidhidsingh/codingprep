package CodingPrep;//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//Note that you must do this in-place without making a copy of the array.
//
//
//
//Example 1:
//
//Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]

class MoveZeroesToEnd {
    public void moveZeroes(int[] nums) {
        //Time Complexity - O(n)
        //Space Complexity - O(1)

        int index = 0;

        for (int i : nums) {
            if ( i != 0)
                nums[index++] = i;
        }

        for (int j = index; j < nums.length; j++)
            nums[j] = 0;
    }
}