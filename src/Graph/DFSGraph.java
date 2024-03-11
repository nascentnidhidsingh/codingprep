package Graph;

import java.util.ArrayList;
import java.util.List;

public class DFSGraph {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = 8;

        for (int i = 0; i <= 8; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(1).add(3);

        adj.get(2).add(1);
        adj.get(2).add(5);
        adj.get(2).add(6);

        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(3).add(7);

        adj.get(4).add(3);
        adj.get(4).add(8);

        adj.get(5).add(2);

        adj.get(6).add(2);

        adj.get(7).add(3);
        adj.get(7).add(8);

        adj.get(8).add(4);
        adj.get(8).add(7);

        System.out.println(dfsTraversal(adj, V));
    }

    private static List<Integer> dfsTraversal(List<List<Integer>> adj, int v) {
        boolean[] vis = new boolean[v + 1];
        List<Integer> list = new ArrayList<>();
        vis[1] = true;
        dfs(1, vis, adj, list);
        return list;
    }

    private static void dfs(int node, boolean[] vis, List<List<Integer>> adj, List<Integer> list) {
        vis[node] = true;
        list.add(node);
        for (int i : adj.get(node)) {
            if (!vis[i]) {
                dfs(i, vis, adj, list);
            }
        }
    }
}
