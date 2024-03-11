package Array;

public class StocksBuySell {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int min = Integer.MAX_VALUE;
        int min_index = 0;
        int i;
        for (i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                min_index = i;
            }
        }
        int max = Integer.MIN_VALUE;
        while (min_index < prices.length) {
            max = Math.max(max, prices[min_index]);
            min_index++;
        }
        int profit = max - min;
        System.out.println(Math.max(profit, 0));

    }

}
