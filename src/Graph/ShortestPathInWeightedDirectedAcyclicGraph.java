package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInWeightedDirectedAcyclicGraph {
    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        ShortestPathInWeightedDirectedAcyclicGraph obj = new ShortestPathInWeightedDirectedAcyclicGraph();
        int[] res = obj.shortestPath(n, m, edge);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    private int[] shortestPath(int n, int m, int[][] edge) {
        List<List<Pairs>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Pairs> temp = new ArrayList<>();
            adj.add(temp);
        }

        for (int i = 0; i < m; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            int wt = edge[i][2];
            adj.get(u).add(new Pairs(v, wt));
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(adj, i, vis, stack);
            }
        }

        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            for (int i = 0; i < adj.get(current).size(); i++) {
                int v = adj.get(current).get(i).first;
                int wt = adj.get(current).get(i).second;
                if ((dis[current] + wt) < dis[v]) {
                    dis[v] = dis[current] + wt;
                }
            }
        }

        return dis;
    }

    private static void dfs(List<List<Pairs>> adj, int node, boolean[] vis, Stack stack) {
        vis[node] = true;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i).first;
            if (!vis[v]) {
                dfs(adj, v, vis, stack);
            }
        }
        stack.push(node);
    }
}

class Pairs {
    int first;
    int second;
    String startword;

    int steps;
    Pairs(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public Pairs(String startWord, int steps) {
        this.startword = startWord;
        this.steps = steps;
    }
}
