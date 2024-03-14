package Graph;

import java.util.LinkedList;
import java.util.Queue;

class GridDistance {
    int row;
    int col;
    int dis;

    GridDistance(int r, int c, int d) {
        this.row = r;
        this.col = c;
        this.dis = d;
    }
}

public class MatrixZeroOneDistance {

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] vis = new boolean[m][n];
        int[][] dis = new int[m][n];

        Queue<GridDistance> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new GridDistance(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, -1, 0, +1};
        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int dist = q.peek().dis;
            dis[row][col] = dist;
            q.remove();
            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];
                if (newCol >= 0 && newCol < n && newRow >= 0 && newRow < m && !vis[newRow][newCol]) {
                    vis[newRow][newCol] = true;
                    q.add(new GridDistance(newRow, newCol, dist + 1));
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dis[i][j]);
            }
            System.out.println();
        }
    }
}

