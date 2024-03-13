package Graph;

public class FloodFill {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0},
                {1, 0, 1},
                {1, 3, 1}};
        int sr = 0;
        int sc = 0;
        int newColor = 2;
        int oldColor = grid[sr][sc];
        dfs(grid, sr, sc, oldColor, newColor);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static void dfs(int[][] grid, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sr >= grid.length || sc < 0 || sc >= grid[0].length || grid[sr][sc] != oldColor)
            return;
        grid[sr][sc] = newColor;
        dfs(grid, sr - 1, sc, oldColor, newColor);
        dfs(grid, sr + 1, sc, oldColor, newColor);
        dfs(grid, sr, sc - 1, oldColor, newColor);
        dfs(grid, sr, sc + 1, oldColor, newColor);
    }
}
