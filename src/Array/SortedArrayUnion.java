package Array;

import java.util.ArrayList;
import java.util.List;

import static Array.RemoveDuplicateInSortedArray.printArrayElement;


public class SortedArrayUnion {
    public static void main(String[] args) {
        int[] ar1 = {1, 2, 3, 4, 4, 5};
        int[] ar2 = {2, 2, 2, 4, 4, 9};
        int[] result = unionOfSortedArray(ar1, ar2);
        printArrayElement(result);
    }

    private static int[] unionOfSortedArray(int[] ar1, int[] ar2) {
        if (ar1 == null && ar2 == null)
            return null;
        if (ar1 == null)
            return ar2;
        if (ar2 == null)
            return ar1;

        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < ar1.length && j < ar2.length) {
            if (ar1[i] <= ar2[j]) {
                if (list.isEmpty() || list.getLast() != ar1[i])
                    list.add(ar1[i]);
                i++;

            } else {
                if (list.isEmpty() || list.getLast() != ar2[j])
                    list.add(ar2[j]);
                j++;
            }
        }
        while (i < ar1.length) {
            list.add(ar1[i++]);
        }
        while (j < ar2.length) {
            list.add(ar2[j++]);
        }
        int index = 0;
        int[] result = new int[list.size()];
        for (int k : list)
            result[index++] = k;
        return result;
    }
}
