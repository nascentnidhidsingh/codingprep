//Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,1]
//Output: true

import java.util.HashSet;
import java.util.Set;

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        //Time Complexity - O(n)
        //Space Complexity - O(n)
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            if(set.contains(i))
                return true;
            else
                set.add(i);
        }
        return false;
    }
}