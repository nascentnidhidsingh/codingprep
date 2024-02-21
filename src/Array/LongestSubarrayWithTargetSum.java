package Array;

public class LongestSubarrayWithTargetSum {
    public static void main(String[] args) {
        //int[] ar = {2, 3, 2, 2, 1, 2, 2, 5};
        int[] ar = {-1, 1, 1};
        int target = 1;

        int i = 0;
        int j = 0;
        int sum = 0;
        int max = 0;

        while (j < ar.length) {
            sum += ar[j];
            if (sum < target)
                j++;
            else if (sum == target) {
                max = Math.max(max, (j - i + 1));
                j++;
            } else {
                while (sum > target) {
                    sum -= ar[i];
                    i++;
                }
                j++;
            }
        }
        System.out.println(max);
    }
}
