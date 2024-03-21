package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
G-36: Shortest Distance in a Binary Maze
Problem Statement:

Given an n * m matrix grid where each element can either be 0 or 1. You need to find the shortest distance between a given source cell to a destination cell. The path can only be created out of a cell if its value is 1.

If the path is not possible between the source cell and the destination cell, then return -1.

Note: You can move into an adjacent cell if that adjacent cell is filled with element 1. Two cells are adjacent if they share a side. In other words, you can move in one of four directions, Up, Down, Left, and Right.

Examples:

Example 1:

Input:
grid[][] = {{1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}}
source = {0, 1}
destination = {2, 2}
Output:
3

Explanation:

1 1 1 1
1 1 0 1
1 1 1 1
1 1 0 0
1 0 0 1
The highlighted part in the above matrix denotes the shortest path from source to destination cell.
*/
public class ShortestDistanceInBinaryMaze {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}};
        int[] source = {0, 1};
        int[] destination = {2, 2};
        System.out.println(shortestPath(grid, source, destination));
    }

    public static int shortestPath(int[][] grid, int[] source, int[] destination) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dis = new int[m][n];
        for (int[] temp : dis) {
            Arrays.fill(temp, Integer.MAX_VALUE);
        }
        Queue<Tuple> q = new LinkedList<>();
        dis[source[0]][source[1]] = 0;
        q.add(new Tuple(0, source[0], source[1]));

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};
        while (!q.isEmpty()) {
            int distance = q.peek().dis;
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1 && (distance + 1 < dis[newRow][newCol])) {
                    dis[newRow][newCol] = distance + 1;
                    if (newRow == destination[0] && newCol == destination[1]) {
                        return dis[newRow][newCol];
                    }
                    q.add(new Tuple(dis[newRow][newCol], newRow, newCol));
                }
            }
        }
        return -1;
    }
}

class Tuple {
    int dis;
    int row;
    int col;

    Tuple(int dis, int row, int col) {
        this.dis = dis;
        this.row = row;
        this.col = col;
    }
}
