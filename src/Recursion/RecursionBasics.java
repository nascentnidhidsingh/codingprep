package Recursion;

public class RecursionBasics {
    public static void main(String[] args) {
        printOneToN(5);
        printNToOne(5);
    }

    private static void printNToOne(int i) {
        if (i == 0)
            return;
        System.out.println(i);
        printNToOne(i - 1);
    }

    private static void printOneToN(int i) {
        if (i == 0)
            return;
        printOneToN(i - 1);
        System.out.println(i);
    }
}
