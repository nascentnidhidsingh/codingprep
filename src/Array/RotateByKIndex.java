package Array;

import static Array.RemoveDuplicateInSortedArray.printArrayElement;
//reverse n-k elements
//reverse k to n elements
//reverse 0 - n elements
//Time - O(n), space - O(1)
public class RotateByKIndex {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5, 6, 7};
        int rotate = 11;
        rotateByKindex(ar, rotate);
        printArrayElement(ar);
    }

    private static void rotateByKindex(int[] ar, int rotate) {
        int length = ar.length;
        rotate = rotate % length;
        if (rotate <= 0)
            return;
        reverse(ar, 0, length - rotate - 1);
        reverse(ar, length - rotate, length - 1);
        reverse(ar, 0, length - 1);
    }

    private static void reverse(int[] ar, int start, int end) {
        while (start < end) {
            int temp = ar[start];
            ar[start] = ar[end];
            ar[end] = temp;
            start++;
            end--;
        }
    }
}
