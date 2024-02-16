package Recursion;

import java.util.HashMap;
import java.util.Map;

public class FibonacciSeriesMemoization {

    public static void main(String[] args) {
        int n = 3;
        Map<Integer,Integer> map = new HashMap<>();
        System.out.println(fibonacciMemoization(n, map));
    }

    private static int fibonacciMemoization(int n, Map<Integer,Integer> map) {
        if (map.containsKey(n))
            return map.get(n);
        if (n <= 2)
            return 1;
        map.put(n, (fibonacciMemoization(n - 1, map) + fibonacciMemoization(n - 2, map)));
        return map.get(n);
    }
}
