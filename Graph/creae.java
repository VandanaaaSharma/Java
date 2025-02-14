package Graph; // Ensure this matches your directory structure

import java.util.ArrayList;

public class GraphExample {
    // Class representing an edge in the graph
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public String toString() {
            return "(" + src + " -> " + dest + ", " + wt + ")";
        }
    }

    public static void main(String[] args) {
        int v = 5; // Number of vertices

        // Suppress the unchecked warning for array creation
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];

        // Initialize adjacency list
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding edges (Bidirectional Graph)
        graph[0].add(new Edge(0, 1, 3));
        graph[1].add(new Edge(1, 0, 3));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        graph[4].add(new Edge(4, 2, 2));

        // Print the adjacency list
        printGraph(graph);
    }

    // Function to print the adjacency list representation of the graph
    public static void printGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Vertex " + i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
