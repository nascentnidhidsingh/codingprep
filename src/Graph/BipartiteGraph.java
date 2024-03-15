package Graph;

import java.util.*;

public class BipartiteGraph {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = 8;
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        /* 1--2--5
           |  |
           3--6

         */
        adj.get(0).add(1);

        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(3);

        adj.get(2).add(1);
        adj.get(2).add(5);
        adj.get(2).add(6);

        adj.get(3).add(1);
        adj.get(3).add(6);

        adj.get(4).add(3);
        adj.get(4).add(8);

        adj.get(5).add(2);

        adj.get(6).add(2);
        adj.get(6).add(3);

        System.out.println(isBartite(V, adj));
    }

    private static boolean isBartite(int V, List<List<Integer>> adj) {
        int[] color = new int[V + 1];
        Arrays.fill(color, -1);
        for (int i = 0; i <= V; i++) {
            if ((bipartiteBFS(i, adj, color))) {
                return true;
            }
        }
        return false;
    }

    private static boolean bipartiteBFS(int source, List<List<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        color[source] = 0;

        while (!q.isEmpty()) {
            int current = q.peek();
            q.remove();
            for (int i : adj.get(current)) {
                if (color[i] != -1) {
                    color[i] = 1 - color[current];
                    q.add(i);
                } else if (color[i] == color[current])
                    return false;
            }
        }
        return true;
    }
}

