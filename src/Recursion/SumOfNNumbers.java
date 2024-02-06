package Recursion;

public class SumOfNNumbers {

    public static void main(String[] args) {
        System.out.println(sum(5));
    }

    public static int sum(int n) {
        if (n == 0)
            return 0;
        return n + sum(n - 1);
    }
}

/*
5 + sum(4)
        4 + sum(3)
                3 + sum(2)
                         2 + sum(1)

 */