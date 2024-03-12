package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Graph - 7, 1-2-3-4, 5-6
O/P : 3
 */
public class CountProvinceBFS {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = 7;
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);

        adj.get(2).add(1);
        adj.get(2).add(3);

        adj.get(3).add(2);
        adj.get(3).add(4);

        adj.get(4).add(3);

        adj.get(5).add(6);
        adj.get(5).add(6);


        System.out.println(countProvince(V, adj));
    }

    private static int countProvince(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V + 1];

        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;

        for (int i = 1; i <= V; i++) {
            if (!vis[i]) {
                q.add(i);
                vis[i] = true;
                while (!q.isEmpty()) {
                    int current = q.poll();
                    for (int j : adj.get(current)) {
                        if (!vis[j]) {
                            q.add(j);
                            vis[j] = true;
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }

}

