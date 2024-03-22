package Graph;

/*G-40: Number of Ways to Arrive at Destination
You are in a city that consists of n intersections numbered from 0 to n – 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array ‘roads’ where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n – 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.

Example 1:


Input:
n=7, m=10
edges= [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
Output:
4
Explanation:
The four ways to get there in 7 minutes (which is the shortest calculated time) are:
- 0  6
- 0  4  6
- 0  1  2  5  6
- 0  1  3  5  6
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWaysToDestination {
    public static void main(String[] args) {
        int n = 7;
        List<List<Integer>> roads = new ArrayList<>() {
            {
                add(new ArrayList<>(Arrays.asList(0, 6, 7)));
                add(new ArrayList<>(Arrays.asList(0, 1, 2)));
                add(new ArrayList<>(Arrays.asList(1, 2, 3)));
                add(new ArrayList<>(Arrays.asList(1, 3, 3)));
                add(new ArrayList<>(Arrays.asList(6, 3, 3)));
                add(new ArrayList<>(Arrays.asList(3, 5, 1)));
                add(new ArrayList<>(Arrays.asList(6, 5, 1)));
                add(new ArrayList<>(Arrays.asList(2, 5, 1)));
                add(new ArrayList<>(Arrays.asList(0, 4, 5)));
                add(new ArrayList<>(Arrays.asList(4, 6, 2)));

            }
        };
        NumberOfWaysToDestination obj = new NumberOfWaysToDestination();
        int ans = obj.countPaths(n, roads);

        System.out.print(ans);
        System.out.println();
    }

    private int countPaths(int n, List<List<Integer>> roads) {
        List<List<Pairs>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> road : roads) {
            adj.get(road.get(0)).add(new Pairs(road.get(1), road.get(2)));
            adj.get(road.get(1)).add(new Pairs(road.get(0), road.get(2)));
        }

        int[] dis = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Arrays.fill(ways, 0);
        ways[0] = 1;
        dis[0] = 0;

        PriorityQueue<Pairs> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        pq.add(new Pairs(0, 0));

        while (!pq.isEmpty()) {
            int distance = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();
            for (Pairs i : adj.get(node)) {
                int adjNode = i.first;
                int eW = i.second;
                if ((eW + distance < dis[adjNode])) {
                    dis[adjNode] = eW + distance;
                    pq.add(new Pairs(eW+distance, adjNode));
                    ways[adjNode] = ways[node];
                } else if (eW + distance == dis[adjNode]) {
                    ways[adjNode] += ways[node];
                }
            }
        }
        return ways[n - 1];
    }
}
