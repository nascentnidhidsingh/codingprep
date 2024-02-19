package Array;

public class FindMissingElement {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 5, 6};
        System.out.println("The missing element is " + findElement(ar));
    }

    private static int findElement(int[] ar) {
//        for (int i = 0; i < ar.length; i++) {
//            if (ar[i] != i + 1)
//                return i+1;
//        }
//        return -1;

//        int xor1 = ar.length;
//        int xor2 = 0;
//        for (int i = 0; i < ar.length - 1; i++) {
//            xor1 = xor1 ^ (i + 1);
//            xor2 = xor2 ^ ar[i];
//        }
//        return (xor1 ^ xor2);

        int sum = ((ar.length + 1) * (ar.length + 2)) / 2;
        int currentSum = 0;
        for (int i : ar) {
            currentSum += i;
        }
        return sum - currentSum;
    }
}
