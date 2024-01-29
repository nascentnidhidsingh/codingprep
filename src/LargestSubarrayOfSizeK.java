import java.util.ArrayList;
import java.util.List;

public class LargestSubarrayOfSizeK {
    public static void largestSubarrayOfSizeK(int[] A, int k) {

        List<Integer> list = new ArrayList<>();
        //[4,1,1,1,2,3,5], O/P:5

        int i = 0;
        int j = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        while (j < A.length) {
            sum += A[j];

            if (sum < k)
                j++;
            else if (sum == k) {
                max = Math.max(max, (j - i + 1));
                j++;
            } else {
                while (sum > k) {
                    sum -= A[i];
                    i++;
                }
                j++;
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        int[] ar = {4, 1, 1, 1, 1, 1, 3, 5};
        largestSubarrayOfSizeK(ar, 5);
    }
}
