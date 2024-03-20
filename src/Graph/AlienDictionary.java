package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        AlienDictionary obj = new AlienDictionary();
        String ans = obj.findOrder(dict, N, K);
        System.out.println(ans);
    }

    private String findOrder(String[] dict, int n, int k) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());

            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get((s1.charAt(j) - 'a')).add((s2.charAt(j) - 'a'));
                    break;
                }
            }
        }
        return topo(adj, k);
    }

    private String topo(List<List<Integer>> adj, int k) {
        int[] indegree = new int[k];

        for (int i = 0; i < k; i++) {
            for (int j : adj.get(i)) {
                indegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int current = q.peek();
            q.remove();
            topo.add(current);
            for (int i : adj.get(current)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }

        StringBuilder str = new StringBuilder();
        for (int i : topo) {
            str.append((char) (i + 'a'));
        }
       return str.toString();
    }
}
