package Array;

import java.util.ArrayList;
import java.util.List;


public class IndexOfSubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 7, 5};
        int sum = 12;
        System.out.println(subarrayWithGivenSum(ar, sum));
    }

    public static List<Integer> subarrayWithGivenSum(int[] ar, int sum) {
        int i = 0;
        int j = 0;
        int currentSum = 0;
        List<Integer> list = new ArrayList<>();
        while (j < ar.length) {
            currentSum += ar[j];
            while (currentSum > sum) {
                currentSum -= ar[i++];
            }
            if (currentSum == sum) {
                list.add(i);
                list.add(j);
                break;
            }
            j++;
        }
        return list;
    }
}
