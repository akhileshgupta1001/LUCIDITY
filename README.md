# Delivery Optimization

## Overview
The Delivery Optimization program helps Aman, a delivery executive, find the best path to deliver orders in the shortest time. It uses Dijkstra's algorithm to calculate the shortest paths between locations.

## Usage
1. Compile the Java source files.
    ```
    javac com/lucidity/DeliveryOptimization.java
    ```
2. Run the main class.
    ```
    java com.lucidity.DeliveryOptimization
    ```

## Classes
- `DeliveryOptimization`: Main class containing the entry point for the program.
- `Edge`: Represents an edge in the graph (connection between locations).
- `Dijkstra`: Contains the implementation of Dijkstra's algorithm to find shortest paths.
- `Pair`: Represents a pair of distance and node.

## Input
- Modify the travel times between locations and other parameters in the `main` method of the `DeliveryOptimization` class.

## Output
The program displays the shortest distances from the starting location (Koramangala) to other locations.

## Dependencies
None

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
