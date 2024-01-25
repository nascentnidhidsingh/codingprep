//Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
//
//
//
//        Example 1:
//
//Input: nums = [1,2,3,1], k = 3
//Output: true

import java.util.HashMap;

class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //Time Complexity - O(n)
        //Space Complexity - O(n)
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int diff = i - map.get(nums[i]);
                if(Math.abs(diff) <= k)
                    return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}