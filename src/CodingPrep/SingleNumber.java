package CodingPrep;//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//
//You must implement a solution with a linear runtime complexity and use only constant extra space.
//
//
//
//Example 1:
//
//Input: nums = [2,2,1]
//Output: 1

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public int singleNumber(int[] nums) {

        // int c = 0;
        // for (int i : nums) {
        //     c = c ^ i;
        // }
        // return c;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
    }
}
