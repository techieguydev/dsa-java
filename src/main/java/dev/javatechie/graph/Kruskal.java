package dev.javatechie.graph;

import java.util.HashSet;
import java.util.Set;

public class Kruskal {

    private static class Edge {
        private int from;
        private int to;
        private int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    private static void addEdge(final HashSet<Edge>[] graph, int from, int to, int weight) {
        graph[from].add(new Edge(from, to, weight));
    }

    public static void main(String[] args) {
        final HashSet<Edge>[] graph = new HashSet[7];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new HashSet<>();
        }
        addEdge(graph, 0, 1, 2);
        addEdge(graph, 0, 2, 3);
        addEdge(graph, 0, 3, 3);
        addEdge(graph, 1, 2, 4);
        addEdge(graph, 2, 3, 5);
        addEdge(graph, 1, 4, 3);
        addEdge(graph, 2, 4, 1);
        addEdge(graph, 3, 5, 7);
        addEdge(graph, 4, 5, 8);
        addEdge(graph, 5, 6, 9);

        System.out.println("Initial Graph: ");
        for(int i = 0; i < graph.length; i++) {
            for(Edge edge : graph[i]) {
                System.out.println(i + " <-- weight " + );
            }
        }

        Kruskal kruskal = new Kruskal();
        HashSet<Edge>[] solGraph = kruskal.kruskal(graph);

        System.out.println("Minimal Graph: ");
        for (int i = 0; i < solGraph.length;)
    }
}
