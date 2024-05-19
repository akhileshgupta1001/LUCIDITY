package com.lucidity.driver;

import com.lucidity.model.Edge;

import java.util.ArrayList;

import static com.lucidity.service.DeliveryOptimizationUtils.findBestRoute;

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
        int koramangala = 0, restaurantR1 = 1, restaurantR2 = 2, customer1 = 3, customer2 = 4;

        // Prepare the adjacency list representing the graph
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < numberOfLocations; i++) {
            adj.add(new ArrayList<>());
        }

        // Define the travel times between locations
        // Assuming average speeds, distances, and preparation times
        // These values can be replaced with actual data
        int travelTimeKoramangalaToR1 = 4; // in minutes
        int travelTimeKoramangalaToR2 = 0; // in minutes
        int travelTimeR1ToR2 = 15; // in minutes
        int travelTimeR1ToC1 = 5; // in minutes
        int travelTimeR1ToC2 = 5; // in minutes
        int travelTimeR2ToC2 = 8; // in minutes
        int travelTimeR2ToC1 = 8; // in minutes
        int travelTimeC1ToC2 = 8; // in minutes

        // Add edges and weights for each location
        getAdjacencyList(adj, koramangala, restaurantR1,
                travelTimeKoramangalaToR1, restaurantR2,
                travelTimeKoramangalaToR2, travelTimeR1ToR2,
                customer1, travelTimeR1ToC1, customer2,
                travelTimeR1ToC2, travelTimeR2ToC1, travelTimeR2ToC2, travelTimeC1ToC2);


        // Preparation times for the restaurants
        int preparationTimeR1 = 5; // in minutes
        int preparationTimeR2 = 10; // in minutes

        int[][] routes = {
                {koramangala, restaurantR1, customer1, restaurantR2, customer2},
                {koramangala, restaurantR2, customer2, restaurantR1, customer1},
                {koramangala, restaurantR1, restaurantR2, customer1, customer2},
                {koramangala, restaurantR1, restaurantR2, customer2, customer1},
                {koramangala, restaurantR2, restaurantR1, customer1, customer2},
                {koramangala, restaurantR2, restaurantR1, customer2, customer1},
        };

        // Run the optimization algorithm to find the best route
        int minTine = findBestRoute( adj, restaurantR1, restaurantR2, preparationTimeR1, preparationTimeR2,routes);

        // Display the optimal route
        System.out.println("\nMinimum Time Required : " + minTine);
    }

    private static void getAdjacencyList(ArrayList<ArrayList<Edge>> adjacencyList, int koramangala, int restaurantR1,
                                         int travelTimeKoramangalaToR1, int restaurantR2,
                                         int travelTimeKoramangalaToR2, int travelTimeR1ToR2,
                                         int c1, int travelTimeR1ToC1, int c2, int travelTimeR1ToC2,
                                         int travelTimeR2ToC1, int travelTimeR2ToC2, int travelTimeC1ToC2) {
        adjacencyList.get(koramangala).add(new Edge(restaurantR1, travelTimeKoramangalaToR1));
        adjacencyList.get(koramangala).add(new Edge(restaurantR2, travelTimeKoramangalaToR2));
        adjacencyList.get(restaurantR1).add(new Edge(restaurantR2, travelTimeR1ToR2));
        adjacencyList.get(restaurantR2).add(new Edge(restaurantR1, travelTimeR1ToR2));
        adjacencyList.get(restaurantR1).add(new Edge(c1, travelTimeR1ToC1));
        adjacencyList.get(restaurantR1).add(new Edge(c2, travelTimeR1ToC2));
        adjacencyList.get(restaurantR2).add(new Edge(c1, travelTimeR2ToC1));
        adjacencyList.get(restaurantR2).add(new Edge(c2, travelTimeR2ToC2));
        adjacencyList.get(c1).add(new Edge(c2, travelTimeC1ToC2));
        adjacencyList.get(c1).add(new Edge(restaurantR2, travelTimeR2ToC1));
        adjacencyList.get(c2).add(new Edge(c1, travelTimeC1ToC2));
        adjacencyList.get(c2).add(new Edge(restaurantR1, travelTimeR1ToC2));
    }


}

