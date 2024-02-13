//Given an array arr[] of n integers, find the maximum that maximizes the sum of the value of i*arr[i] where i varies from 0 to n-1.
//
//Examples:
//
//Input: arr[] = {8, 3, 1, 2}
//Output: 29
//Explanation: Lets look at all the rotations,
//{8, 3, 1, 2} = 8*0 + 3*1 + 1*2 + 2*3 = 11
//        {3, 1, 2, 8} = 3*0 + 1*1 + 2*2 + 8*3 = 29
//        {1, 2, 8, 3} = 1*0 + 2*1 + 8*2 + 3*3 = 27
//        {2, 8, 3, 1} = 2*0 + 8*1 + 3*2 + 1*3 = 17
//
//
//
package Array;

public class MaxSumWithIndexes {

    public static void main(String[] args) {
        int[] ar = {8, 3, 1, 2};
        System.out.println("Maximum sum of the value of i*arr[i] : " + maxSum(ar));
    }

    private static int maxSum(int[] ar) {
        int sum = 0;
        int currentSum = 0;
        for (int i = 0; i < ar.length; i++) {
            currentSum += ar[i] * i;
            sum += ar[i];
        }

        System.out.println("Current value of i*arr[i] : " + currentSum);
        int maxSum = 0;
        for (int i = 1; i < ar.length; i++) {
            int runningSum = (currentSum - sum + (ar[i - 1] * ar.length));
            maxSum = Math.max(maxSum, runningSum);
            System.out.println("Current value of i*arr[i] : " + runningSum);
        }
        return maxSum;
    }

}
