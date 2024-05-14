package com.lucidity;

/**
 * Represents an edge with a destination and weight.
 */
class Edge {
    int destination;
    int weight;

    /**
     * Constructs an Edge object.
     * @param destination The destination location
     * @param weight The weight (travel time) associated with the edge
     */
    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}