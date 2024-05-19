package com.lucidity.model;


/**
 * Represents a pair of distance and node.
 */
class Pair {
    int distance;
    int node;

    /**
     * Constructs a Pair object.
     * @param distance The distance from the starting location
     * @param node The node (location)
     */
    public Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}
