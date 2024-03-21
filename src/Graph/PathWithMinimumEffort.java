package Graph;

/*G-37: Path With Minimum Effort
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of the cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e.,0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route’s effort is the maximum absolute difference in heights between two consecutive cells of the route.

Examples:

Example 1:
Input:
heights = [[1,2,2],[3,8,2],[5,3,5]]
Output:
2
Explanation:

The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        int m = heights.length;
        int n = heights[0].length;
        int[] source = {0, 0};
        int[] destination = {m - 1, n - 1};
        int res = pathWithMinEffort(heights, source, destination);
        System.out.println(res);
    }

    private static int pathWithMinEffort(int[][] heights, int[] source, int[] destination) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dis = new int[m][n];
        for (int[] temp : dis) {
            Arrays.fill(temp, Integer.MAX_VALUE);
        }
        dis[0][0] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dis));
        pq.add(new Tuple(0, source[0], source[1]));
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};

        while (!pq.isEmpty()) {
            int diff = pq.peek().dis;
            int row = pq.peek().row;
            int col = pq.peek().col;
            pq.remove();
            if (row == destination[0] && col == destination[1]) {
                return diff;
            }
            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    int maxEffort = Math.max(Math.abs(heights[row][col] - heights[newRow][newCol]), diff);
                    if (maxEffort < dis[newRow][newCol]) {
                        dis[newRow][newCol] = maxEffort;
                        pq.add(new Tuple(maxEffort, newRow, newCol));
                    }
                }
            }
        }
        return 0;
    }
}
