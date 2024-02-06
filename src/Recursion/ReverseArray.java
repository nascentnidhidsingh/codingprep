package Recursion;

public class ReverseArray {

    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5};
        int start = 0;
        int end = ar.length - 1;
        reverseRecursion(ar, start, end);
        getPrintArray(ar);
    }

    private static void getPrintArray(int[] ar) {
        for (int i = 0; i < ar.length; i++)
            System.out.println(ar[i]);
    }

    private static int[] reverseRecursion(int[] ar, int start, int end) {
        if (start == end)
            return ar;
        int temp = ar[start];
        ar[start] = ar[end];
        ar[end] = temp;
        return reverseRecursion(ar, start + 1, end - 1);
    }
}
