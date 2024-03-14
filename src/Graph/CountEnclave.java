package Graph;

import java.util.LinkedList;
import java.util.Queue;

/*
* You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

Example 1:
Input: grid =
* [[0,0,0,0],
* [1,0,1,0],
* [0,1,1,0],
* [0,0,0,0]]
Output: 3
*/
class CountEnclave {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 0}};
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == (m - 1) || j == (n - 1)) && grid[i][j] == 1) {
                    vis[i][j] = true;
                    q.add(new Pair(i, j));
                }
            }
        }

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, -1, 0, +1};
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            grid[r][c] = 0;
            vis[r][c] = true;
            q.remove();
            for (int i = 0; i < 4; i++) {
                int newRow = r + delRow[i];
                int newCol = c + delCol[i];
                if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && !vis[newRow][newCol] && grid[newRow][newCol] == 1) {
                    vis[newRow][newCol] = true;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
        int count = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
