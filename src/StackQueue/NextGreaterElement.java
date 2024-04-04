package StackQueue;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] ar = {3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9};
        int[] result = nextGreaterElement(ar);
        for (int i : result)
            System.out.print(i + "  ");
    }

    private static int[] nextGreaterElement(int[] ar) {
        Stack<Integer> nextGreater = new Stack<>();
        int[] nge = new int[ar.length];
        int length = ar.length;
        for (int i = (2 * length) - 1; i >= 0; i--) {
            while (!nextGreater.isEmpty() && ar[i % length] >= nextGreater.peek()) {
                nextGreater.pop();
            }
            if (i < length) {
                if (!nextGreater.isEmpty()) {
                    nge[i] = nextGreater.peek();
                } else {
                    nge[i] = -1;
                }
            }
            nextGreater.push(ar[i % length]);
        }
        return nge;
    }
}
