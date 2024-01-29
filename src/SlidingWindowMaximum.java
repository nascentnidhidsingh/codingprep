import java.util.ArrayDeque;
import java.util.ArrayList;

//You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
//
//        Return the max sliding window.
//
//
//
//        Example 1:
//
//        Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//        Output: [3,3,5,5,6,7]
//        Explanation:
//        Window position                Max
//        ---------------               -----
//        [1  3  -1] -3  5  3  6  7       3
//        1 [3  -1  -3] 5  3  6  7       3
//        1  3 [-1  -3  5] 3  6  7       5
//        1  3  -1 [-3  5  3] 6  7       5
//        1  3  -1  -3 [5  3  6] 7       6
//        1  3  -1  -3  5 [3  6  7]      7

import java.util.Deque;
import java.util.List;

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] A, int k) {

        List<Integer> list = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        int i = 0;
        int j = 0;

        while (j < A.length) {
            while (!q.isEmpty() && q.getLast() < A[j]) {
                q.removeLast();
            }
            q.addLast(A[j]);
            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {
                list.add(q.getFirst());
                if (A[i] == q.getFirst()) {
                    q.removeFirst();
                }
                i++;
                j++;
            }

        }

        int[] result = new int[list.size()];

        int x = 0;
        for (int data : list)
            result[x++] = data;
        return result;
    }
}