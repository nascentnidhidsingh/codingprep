package Graph;

import java.util.*;

public class ShortestPathInUnitWeightUnDirectedGraph {
    public static void main(String[] args) {
        int n = 9, m = 10;
        int[][] edge = {{0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6}, {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}};

        ShortestPathInUnitWeightUnDirectedGraph obj = new ShortestPathInUnitWeightUnDirectedGraph();
        int[] res = obj.shortestPath(edge, n, m);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    private int[] shortestPath(int[][] edge, int n, int m) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edge[i][0]).add(edge[i][1]);
            adj.get(edge[i][1]).add(edge[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;

        while (!q.isEmpty()) {
            int current_node = q.peek();
            q.poll();
            for (int i : adj.get(current_node)) {
                if (dis[current_node] + 1 < dis[i]) {
                    dis[i] = dis[current_node] + 1;
                    q.add(i);
                }
            }
        }
        return dis;
    }
}

