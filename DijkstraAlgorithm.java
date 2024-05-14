package com.lucidity;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Class to handle Dijkstra's algorithm for finding shortest paths.
 */
public class DijkstraAlgorithm {
    /**
     * Finds the shortest distances from a starting location using Dijkstra's algorithm.
     * @param V Number of vertices (locations)
     * @param adj Adjacency list representing the graph
     * @param S Starting location
     * @return Array of shortest distances from the starting location
     */
    static int[] shortestDistances(int V, ArrayList<ArrayList<Edge>> adj, int S) {
        PriorityQueue<Pair>
                pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            for (Edge edge : adj.get(node)) {
                int adjNode = edge.destination;
                int edgeWeight = edge.weight;

                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        return dist;
    }
}
