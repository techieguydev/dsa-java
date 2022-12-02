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
        final Set<Edge>[] graph = new HashSet[7];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new HashSet<>();
        }
        addEdge(graph, );
    }
}
