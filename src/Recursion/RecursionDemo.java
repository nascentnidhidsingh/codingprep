package Recursion;

public class RecursionDemo {

    static int currentCount = 0;

    public static void main(String[] args) {
        count();
        printName("Akshay", 5);
        printData(5);
    }

    private static void count() {

        if (currentCount == 4)
            return;
        System.out.println(currentCount);
        currentCount++;
        count();
    }

    public static void printName(String name, int n) {
        if (n == 0)
            return;
        System.out.println(name);
        printName(name, n - 1);
    }

    //Backtracking
    public static void printData(int n) {
        if (n == 0)
            return;
        printData(n - 1);
        System.out.println(n);
    }
}
