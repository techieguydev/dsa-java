package dev.javatechie.graph;

import java.util.HashSet;

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
        graph[from].add()
    }
}
