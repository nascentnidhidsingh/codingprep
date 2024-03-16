package Graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int node = 10;

        for (int i = 0; i <= node; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(7).add(5);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        adj.get(8).add(2);

        boolean cycle = false;
        boolean[] vis = new boolean[node + 1];
        boolean[] pathVis = new boolean[node + 1];
        for (int i = 0; i <= node; i++) {
            if (!vis[i]) {
                if ((dfs(adj, i, pathVis, vis))) {
                    cycle = true;
                    break;
                }
            }
        }
        System.out.println(cycle);
    }

    public static boolean dfs(List<List<Integer>> adj, int node, boolean[] pathVis, boolean[] vis) {
        pathVis[node] = true;
        vis[node] = true;

        for (int i : adj.get(node)) {
            if (!vis[i]) {
                if (dfs(adj, i, pathVis, vis)) {
                    return true;
                }
            } else if (pathVis[node]) {
                return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
}
