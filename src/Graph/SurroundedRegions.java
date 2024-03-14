package Graph;

import java.util.LinkedList;
import java.util.Queue;

/*Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.
Example 1:
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]*/
public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] board =
                {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        solve(board);
    }

    public static void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];
        Queue<PairData> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || (i == (m - 1)) || (j == (n - 1))) && board[i][j] == 'O') {
                    vis[i][j] = true;
                    q.add(new PairData(i, j));
                }
            }
        }

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, -1, 0, +1};

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            vis[r][c] = true;
            q.remove();
            for (int i = 0; i < 4; i++) {
                int newRow = r + delRow[i];
                int newCol = c + delCol[i];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !vis[newRow][newCol] && board[newRow][newCol] == 'O') {
                    vis[newRow][newCol] = true;
                    q.add(new PairData(newRow, newCol));
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
        for (char[] chars : board) {
            for (int j = 0; j < n; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }
}

class PairData {
    int row;
    int col;

    PairData(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

