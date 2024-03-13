package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class CountIslandsBFSDFS {
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0},
                {0, 0, 1},
                {1, 1, 1}};
        int m = grid.length;
        int n = grid[0].length;
        int islandCount = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    bfs(grid, row, col);
                    dfs(grid, row, col);
                    islandCount++;
                }
            }
        }
        System.out.println(islandCount);
    }

    private static void bfs(int[][] grid, int row, int col) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        while (!q.isEmpty()) {
            row = q.peek().row;
            col = q.peek().col;
            q.remove();
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int newRow = row + i;
                    int newCol = col + j;
                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1) {
                        q.add(new Pair(newRow, newCol));
                        grid[newRow][newCol] = 2;
                    }
                }
            }
        }
    }

    private static void dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return;
        }
        grid[row][col] = 0;
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
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
