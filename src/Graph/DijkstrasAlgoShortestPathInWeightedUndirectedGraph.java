package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstrasAlgoShortestPathInWeightedUndirectedGraph {
    public static void main(String[] args) {
        int V = 3, S = 2;
        ArrayList<Integer> node1 = new ArrayList<>() {{
            add(1);
            add(1);
        }};
        ArrayList<Integer> node2 = new ArrayList<>() {{
            add(2);
            add(6);
        }};
        ArrayList<Integer> node3 = new ArrayList<>() {{
            add(2);
            add(3);
        }};
        ArrayList<Integer> node4 = new ArrayList<>() {{
            add(0);
            add(1);
        }};
        ArrayList<Integer> node5 = new ArrayList<>() {{
            add(1);
            add(3);
        }};
        ArrayList<Integer> node6 = new ArrayList<>() {{
            add(0);
            add(6);
        }};
        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<>() {{
            add(node1);
            add(node2);
        }};

        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<>() {{
            add(node3);
            add(node4);
        }};
        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<>() {{
            add(node5);
            add(node6);
        }};
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>() {{
            add(inter1);
            add(inter2);
            add(inter3);
        }};

        DijkstrasAlgoShortestPathInWeightedUndirectedGraph obj = new DijkstrasAlgoShortestPathInWeightedUndirectedGraph();

        int[] res = obj.dijkstra(adj, V, S);

        for (int i = 0; i < V; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    private int[] dijkstra(ArrayList<ArrayList<ArrayList<Integer>>> adj, int v, int source) {
        int[] dis = new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);
        //Min Heap
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        pq.add(new Double(0, source));
        dis[source] = 0;
        while (!pq.isEmpty()) {
            int distance = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if (distance + edgeWeight < dis[adjNode]) {
                    dis[adjNode] = distance + edgeWeight;
                    pq.add(new Double(dis[adjNode], adjNode));
                }
            }
        }
        return dis;
    }
}

class Double {
    int distance;
    int node;

    Double(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}
