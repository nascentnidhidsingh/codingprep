package Array;

public class ArrayIsSorted {
    public static void main(String[] args) {
        int[] ar = {1, 2, 2, 3, 1, 6};

        System.out.println(arrayIsSorted(ar));
    }

    private static boolean arrayIsSorted(int[] ar) {
        for (int i = 1; i < ar.length ; i++) {
            if (ar[i] < ar[i - 1])
                return false;
        }
        return true;
    }
}
