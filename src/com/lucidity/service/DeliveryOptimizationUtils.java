package com.lucidity.service;

import com.lucidity.model.Edge;

import java.util.ArrayList;
import java.util.Arrays;

public class DeliveryOptimizationUtils {
    /**
     * Finds the best route for Aman to deliver the orders.
     * @param adjacencyList Adjacency list representing the graph
     * @param restaurantR1 Restaurant 2 location
     * @param firstPoint Preparation time at Restaurant 1
     * @param secondPoint Preparation time at Restaurant 2
     * @return The best route as an array of locations
     */
    public static int findBestRoute(ArrayList<ArrayList<Edge>> adjacencyList, int restaurantR1, int restaurantR2, int firstPoint, int secondPoint, int[][] routes) {

        int minTime = Integer.MAX_VALUE;
        int[] bestRoute = null;

        for (int[] route : routes) {
            int currentTime = calculateRouteTime(route, adjacencyList, firstPoint, secondPoint, restaurantR1, restaurantR2);
            if (currentTime < minTime) {
                minTime = currentTime;
                bestRoute = route;
            }
            System.out.println("\n ****************** Routes ************************");
            System.out.println(" Routes : "+ Arrays.toString(route)+ " , current Time : "+currentTime+" , minTime ="+minTime);
            System.out.println("****************** Routes ************************\n");

        }
        System.out.println("******************************************");
        System.out.println("Best Routes : "+Arrays.toString(bestRoute));
        System.out.println("******************************************");

        return minTime;
    }

    /**
     * Calculates the total time for a given route.
     * @param route Array representing the sequence of locations to visit
     * @param adjacencyList Adjacency list representing the graph
     * @param firstPoint Preparation time at Restaurant 1
     * @param secondPoint Preparation time at Restaurant 2
     * @param restaurantR1 Restaurant 1 location
     * @param restaurantR2 Restaurant 2 location
     * @return The total time for the route
     */
    private static int calculateRouteTime(int[] route, ArrayList<ArrayList<Edge>> adjacencyList, int firstPoint, int secondPoint, int restaurantR1, int restaurantR2) {
        int totalTime = 0;
        for (int i = 0; i < route.length - 1; i++) {
            int from = route[i];
            int to = route[i + 1];
            int travelTime = getTravelTime(from, to, adjacencyList);
            totalTime += travelTime;
            if (to == restaurantR1) {
                totalTime = Math.max(totalTime, firstPoint);
            } else if (to == restaurantR2) {
                totalTime = Math.max(totalTime, secondPoint);
            }
            System.out.println(" from : "+from+" , to : "+to+" , travelTime = "+travelTime+" , totalTime = "+totalTime);
        }

        return totalTime;
    }

    /**
     * Gets the travel time between two locations.
     * @param from Starting location
     * @param to Destination location
     * @param adjacencyList Adjacency list representing the graph
     * @return The travel time between the two locations
     */
    private static int getTravelTime(int from, int to, ArrayList<ArrayList<Edge>> adjacencyList) {
        for (Edge edge : adjacencyList.get(from)) {
            if (edge.destination == to) {
                return edge.weight;
            }
        }
        return Integer.MAX_VALUE; // Should not happen
    }
}
