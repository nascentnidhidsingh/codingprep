package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph {
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

        System.out.println(bfsTraversal(adj, V));
    }


    private static List<Integer> bfsTraversal(List<List<Integer>> adj, int v) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[v + 1];
        queue.add(1);
        vis[1] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            for (int i : adj.get(current)) {
                if (!vis[i]) {
                    vis[i] = true;
                    queue.add(i);
                }
            }
        }
        return result;
    }
}
