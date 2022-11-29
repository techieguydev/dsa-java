package dev.javatechie.graph;

public class Kruskal {

    private static class Edge {
        private int from;
        private int to;
        private int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
        }
    }
}
