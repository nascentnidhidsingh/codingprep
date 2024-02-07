package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceOfArray {
    public static void main(String[] args) {
        int i = 0;
        int[] ar = {3, 1, 2};
        List<Integer> list = new ArrayList<>();
        subsequence(i, list, ar);
    }

    private static void subsequence(int i, List<Integer> list, int[] ar) {
        if (i == ar.length) {
            System.out.println(list);
            return;
        }
        list.add(ar[i]);
        subsequence(i + 1, list, ar);
        list.removeLast();
        subsequence(i + 1, list, ar);
    }
}
