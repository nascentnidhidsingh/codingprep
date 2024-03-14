package Graph;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    public static void main(String[] args) {
        int[][] grid =
                {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Set<StringBuilder> set = new HashSet<>();


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    StringBuilder str = new StringBuilder();
                    dfs(grid, vis, i, j, str, i, j);
                    set.add(str);
                }
            }
        }
        System.out.println(set.size());
    }

    public static void dfs(int[][] grid, boolean[][] vis, int i, int j,StringBuilder str, int row0, int col0) {
        vis[i][j] = true;
        str.append(i - row0);
        str.append(j - col0);
        //str.append(",");
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};
        int m = grid.length;
        int n = grid[0].length;

        for (int k = 0; k < 4; k++) {
            int newRow = i + delRow[k];
            int newCol = j + delCol[k];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1 && !vis[newRow][newCol]) {
                dfs(grid, vis, newRow, newCol, str, row0, col0);
            }
        }
    }
}
