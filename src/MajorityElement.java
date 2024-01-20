//Given an array nums of size n, return the majority element.
//
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
//
//
//
//Example 1:
//
//Input: nums = [3,2,3]
//Output: 3

class MajorityElement {
    public int majorityElement(int[] nums) {

        // //Time Complexity - O(n)
        // //Space Complexity - O(n)

        // HashMap<Integer,Integer> map = new HashMap<>();

        // for (int i : nums)
        // map.put(i, (map.getOrDefault(i, 0)+1));

        // System.out.print(map);

        // for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
        //     if (entry.getValue() > nums.length/2)
        //     return entry.getKey();
        // }
        // return -1;

        int element = -1;
        int count = 0;

        //Time Complexity - O(n)
        //Space Complexity - O(1)
        for (int i : nums) {
            if (count == 0) {
                element = i;
                count++;
            } else {
                if (i == element)
                    count++;
                else count--;
            }
        }
        return element;
    }
}