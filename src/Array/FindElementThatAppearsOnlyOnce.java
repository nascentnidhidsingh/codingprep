package Array;

public class FindElementThatAppearsOnlyOnce {
    public static void main(String[] args) {
        int[] ar = {4,1,2,1,2};
        int xor = 0;
        for (int i : ar) {
            xor = xor ^ i;
        }
        System.out.println(xor);
    }
}
