package Array;

import static Array.RemoveDuplicateInSortedArray.printArrayElement;

//Time Complexity - O(n)
//Space Complexity - O(1)
public class LeftRotateByOne {
    public static void main(String[] args) {
        int[] ar = {1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5};
        leftRotate(ar);
        printArrayElement(ar);
    }

    private static void leftRotate(int[] ar) {

        if (ar == null || ar.length < 2)
            return;

        int lastElement = ar[0];

        for (int i = 1; i < ar.length; i++) {
            ar[i - 1] = ar[i];
        }
        ar[ar.length - 1] = lastElement;
    }
}
