package Graph;

import java.util.ArrayList;
import java.util.List;

class CountProvince {
    public int findCircleNum(int[][] isConnected) {

        //Convert adj matrix to List
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count = 0;
        boolean[] vis = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!vis[i]) {
                count++;
                dfs(vis, i, adj);
            }
        }
        return count;
    }

    public static void dfs(boolean[] vis, int i, List<List<Integer>> adj) {
        vis[i] = true;
        for (int k : adj.get(i)) {
            if (!vis[k]) {
                dfs(vis, k, adj);
            }
        }
    }
}