package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
G-38: Cheapest Flights Within K Stops
There are n cities and m edges connected by some number of flights. You are given an array of flights where flights[i] = [ fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost price. You have also given three integers src, dst, and k, and return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

Example 1:


Input:
n = 4
flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]]
src = 0
dst = 3
k = 1
Output:
700
Explanation:
The optimal path with at most 1 stops from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
 */
public class CheapestFlightWithinKStops {
    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        int result = findCheapestFlight(adj, K, src, dst, n);
        System.out.println(result);
    }

    private static int findCheapestFlight(ArrayList<ArrayList<Pair>> adj, int k, int src, int dst, int n) {
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);

        dis[src] = 0;
        Queue<Tuples> q = new LinkedList<>();
        q.add(new Tuples(0, src, 0));

        while (!q.isEmpty()) {
            int stops = q.peek().first;
            int node = q.peek().second;
            int cost = q.peek().third;
            q.remove();
            if (stops > k) continue;
            for (Pair i : adj.get(node)) {
                int adjNode = i.row;
                int eW = i.col;
                if (eW + cost < dis[adjNode]) {
                    dis[adjNode] = eW + cost;
                    q.add(new Tuples((stops + 1), adjNode, cost + eW));
                }
            }
        }
        if (dis[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return dis[dst];
    }


}

class Tuples {
    int first;
    int second;
    int third;

    Tuples(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
