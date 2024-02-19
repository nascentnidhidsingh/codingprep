package Array;

public class MaximumZeros {
    public static void main(String[] args) {
        int[] ar = {1, 1, 1, 0, 0, 0};

        int max = 0;
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == 1)
                count++;
            else count = 0;
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
