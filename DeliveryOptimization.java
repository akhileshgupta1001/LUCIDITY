package com.lucidity;

import java.util.ArrayList;


/**
 * Aman's Delivery Optimization Program.
 * Helps Aman find the best path to deliver orders in the shortest time.
 */
public class DeliveryOptimization {

    /**
     * Main method to run the delivery optimization.
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Assuming geo-locations: Koramangala, R1, R2, C1, C2
        int numberOfLocations = 5;
        int koramangala = 0, r1 = 1, r2 = 2, c1 = 3, c2 = 4;

        // Prepare the adjacency list representing the graph
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < numberOfLocations; i++) {
            adj.add(new ArrayList<>());
        }

        // Define the travel times between locations
        // Assuming average speeds, distances, and preparation times
        // These values can be replaced with actual data
        int travelTimeKoramangalaToR1 = 10; // in minutes
        int travelTimeKoramangalaToR2 = 15; // in minutes
        int travelTimeR1ToC1 = 5; // in minutes
        int travelTimeR2ToC2 = 8; // in minutes

        // Add edges and weights for each location
        adj.get(koramangala).add(new Edge(r1, travelTimeKoramangalaToR1));
        adj.get(koramangala).add(new Edge(r2, travelTimeKoramangalaToR2));
        adj.get(r1).add(new Edge(c1, travelTimeR1ToC1));
        adj.get(r2).add(new Edge(c2, travelTimeR2ToC2));

        // Aman starts from Koramangala
        int startLocation = koramangala;

        // Run Dijkstra's algorithm to find the shortest paths
        int[] shortestDistances = DijkstraAlgorithm.shortestDistances(numberOfLocations, adj, startLocation);

        // Display the shortest distances from the starting location
        System.out.println("Shortest distances from Koramangala:");
        for (int i = 0; i < numberOfLocations; i++) {
            System.out.println("To Location " + i + ": " + (shortestDistances[i] == Integer.MAX_VALUE ? "INF" : shortestDistances[i]) + " minutes");
        }
    }
}




