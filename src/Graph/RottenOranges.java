package Graph;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given an m x n grid where each cell can have one of three values:
0 representing an empty cell,
1 representing a fresh orange,
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
*/
public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 2},
                {0, 0, 1},
                {2, 1, 1}};

        Queue<Triple> q = new LinkedList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Triple(i, j, 0));
                    vis[i][j] = true;
                }
                 else {
                     vis[i][j] = false;
                }
            }
        }
        int maxTime = Integer.MIN_VALUE;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int time = q.peek().time;
            maxTime = Math.max(maxTime, time);
            q.remove();
            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];
                if ((newRow >= 0) && (newRow < grid.length) && (newCol >= 0) && (newCol < grid[0].length) && (grid[newCol][newCol] == 1) && (!vis[newRow][newCol])) {
                    grid[newRow][newCol] = 2;
                    vis[newRow][newCol] = true;
                    q.add(new Triple(newRow, newCol, time + 1));
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    maxTime = -1;
                    break;
                }
            }
        }
        System.out.println(maxTime);
    }
}

class Triple {
    int row;
    int col;
    int time;

    Triple(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
