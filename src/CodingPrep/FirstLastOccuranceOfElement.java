package CodingPrep;

import java.util.ArrayList;
import java.util.List;

public class FirstLastOccuranceOfElement {

    public static void firstAndLastOccurance(int ar[], int target) {

        List<Integer> list = new ArrayList<>();

        int firstOccurance = findFirstOccurance(ar,target);
        int lastOccurance = findLastOccurance(ar,target);

        list.add(firstOccurance);
        list.add(lastOccurance);
        System.out.println(list);
    }

    private static int findLastOccurance(int[] ar, int target) {
        int ans = -1;
        int start = 0 ;
        int end = ar.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (ar[mid] == target) {
                ans = mid;
                start = mid + 1;
            } else if ( ar[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return ans;
    }

    private static int findFirstOccurance(int[] ar, int target) {
        int ans = -1;
        int start = 0 ;
        int end = ar.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (ar[mid] == target) {
                ans = mid;
                end = mid - 1;
            } else if ( ar[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
        int x = 2;
        firstAndLastOccurance(arr, x);
    }

}
