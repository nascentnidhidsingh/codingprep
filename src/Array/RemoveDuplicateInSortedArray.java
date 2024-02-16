package Array;

public class RemoveDuplicateInSortedArray {

    //0(n) Time complexity, O(1) space complexity
    public static void main(String[] args) {
        int[] ar = {1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5};
        removeDuplicate(ar);
        printArrayElement(ar);
    }

    public static void printArrayElement(int[] ar) {
        System.out.print(ar[0]);
        for (int i = 1; i < ar.length; i++) {
            System.out.print( "," + ar[i]);
        }
    }

    public static void removeDuplicate(int[] ar) {
        int k = 1;
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] != ar[i-1])
                ar[k++] = ar[i];
        }
    }
}
