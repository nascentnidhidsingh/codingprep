package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceWithSumK {


    public static void main(String[] args) {
        int[] ar = {3, 1, 2};
        int sum = 3;
        List<Integer> list = new ArrayList<>();
        System.out.println("Subsequence with Sum k : ");
        subsequence(0, list, ar, sum, 0);
        System.out.println("First Subsequence with Sum k : ");
        firstSubsequence(0, list, ar, sum, 0);
        System.out.println("Number of Subsequence with Sum k : ");
        System.out.println(countSubsequence(0, ar, sum, 0));
    }

    private static void subsequence(int i, List<Integer> list, int[] ar, int sum, int currentSum) {
        if (i == ar.length) {
            if (sum == currentSum)
                System.out.println(list);
            return;
        }
        list.add(ar[i]);
        currentSum = currentSum + ar[i];
        subsequence(i + 1, list, ar, sum, currentSum);
        int x = list.removeLast();
        currentSum = currentSum - x;
        subsequence(i + 1, list, ar, sum, currentSum);
    }

    private static boolean firstSubsequence(int i, List<Integer> list, int[] ar, int sum, int currentSum) {
        if (i == ar.length) {
            if (sum == currentSum) {
                System.out.println(list);
                return true;
            }
            return false;
        }
        list.add(ar[i]);
        currentSum = currentSum + ar[i];
        if (firstSubsequence(i + 1, list, ar, sum, currentSum))
            return true;
        int x = list.removeLast();
        currentSum = currentSum - x;
        return firstSubsequence(i + 1, list, ar, sum, currentSum);
    }

    private static int countSubsequence(int i, int[] ar, int sum, int currentSum) {
        if (i == ar.length) {
            if (sum == currentSum)
                return 1;
            return 0;
        }
        currentSum += ar[i];
        int left = countSubsequence(i + 1, ar, sum, currentSum);
        currentSum -= ar[i];
        int right = countSubsequence(i + 1, ar, sum, currentSum);
        return left + right;
    }
}

