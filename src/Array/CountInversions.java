package Array;

import java.util.ArrayList;

public class CountInversions {
    public static void main(String[] args) {
        int[] ar = {5, 4, 3, 2, 1};
        System.out.println(numberOfInversions(ar));
    }

    private static int numberOfInversions(int[] ar) {
        return mergeSort(ar, 0, ar.length - 1);
    }

    private static int mergeSort(int[] ar, int low, int high) {
        int cnt = 0;
        if (low >= high)
            return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(ar, low, mid);
        cnt += mergeSort(ar, mid + 1, high);
        cnt += merge(ar, low, mid, high);
        return cnt;
    }

    private static int merge(int[] ar, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int cnt = 0;

        ArrayList<Integer> list = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (ar[left] <= ar[right]) {
                list.add(ar[left]);
                left++;
            } else {
                list.add(ar[right]);
                cnt += mid - left + 1;
                right++;
            }
        }

        while (left <= mid) {
            list.add(ar[left]);
            left++;
        }

        while (right < ar.length) {
            list.add(ar[right]);
            right++;
        }
        return cnt;
    }
}
