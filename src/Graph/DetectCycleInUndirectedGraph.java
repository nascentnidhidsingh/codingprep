package Graph;

import java.util.*;

class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = 8;
        for (int i = 0; i <= V; i++) {
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

        System.out.println(detectCycle(adj));
    }

    private static boolean detectCycle(List<List<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()];
        vis[0] = true;
        vis[1] = true;
        Queue<NodeParent> q = new LinkedList<>();
        q.add(new NodeParent(1, -1));

        while (!q.isEmpty()) {
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.remove();
            for (int current : adj.get(node)) {
                if (!vis[current]) {
                    vis[current] = true;
                    q.add(new NodeParent(current, node));
                } else if (parent != current) {
                    return true;
                }
            }
        }
        return false;
    }
}

class NodeParent {
    int node;
    int parent;

    NodeParent(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}