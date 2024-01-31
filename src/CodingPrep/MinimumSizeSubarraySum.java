package CodingPrep;

class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {

        int i = 0;
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                min = Math.min(min, (j - i + 1));
                sum -= nums[i++];
            }
            j++;
        }
        return (min != Integer.MAX_VALUE) ? min : 0;
    }

    public static void main(String[] args) {
        int[] ar = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, ar));
    }
}