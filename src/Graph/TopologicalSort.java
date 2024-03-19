package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = 6;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topoSort(i, vis, adj, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

    }

    public static void topoSort(int node, boolean[] vis, List<List<Integer>> adj, Stack<Integer> stack) {
        vis[node] = true;
        for (int current : adj.get(node)) {
            if (!vis[current]) {
                topoSort(current, vis, adj, stack);
            }
        }
        stack.push(node);
    }
}
