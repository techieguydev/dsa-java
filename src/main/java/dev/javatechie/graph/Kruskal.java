package dev.javatechie.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * The Kruskal class.
 */
public class Kruskal {

    private static class Edge {
        private int from;
        private int to;
        private int weight;

        /**
         * Instantiates a new Edge object.
         *
         * @param from   the from node
         * @param to     the to node
         * @param weight the weight of the node
         */
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    private static void addEdge(final HashSet<Edge>[] graph, int from, int to, int weight) {
        graph[from].add(new Edge(from, to, weight));
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
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
        for (int i = 0; i < solGraph.length; i++) {
            for (Edge edge : solGraph[i]) {
                System.out.println(i + " <-- weight " + edge.weight + " --> " + edge.to);
            }
        }
    }

    /**
     * Kruskal main function.
     *
     * @param graph the HashSet
     * @return the array of HashSet object
     */
    public HashSet<Edge>[] kruskal(final HashSet<Edge>[] graph) {
        int nodes = graph.length;
        int[] captain = new int[nodes];

        HashSet<Integer>[] connectedGroups = new HashSet[nodes];
        HashSet<Edge>[] minGraph = new HashSet[nodes];
        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        for(int i = 0; i < nodes; i++) {
            minGraph[i] = new HashSet<>();
            connectedGroups[i] = new HashSet<>();
            connectedGroups[i].add(i);
            captain[i] = i;
            edges.addAll(graph[i]);
        }

        int connectedElements = 0;
        while(connectedElements != nodes && !edges.isEmpty()) {
            final Edge edge = edges.poll();
            if(!connectedGroups[captain[edge.from]].contains(edge.to) && !connectedGroups[captain[edge.to]].contains(edge.from)) {
                connectedGroups[captain[edge.from]].addAll(connectedGroups[captain[edge.to]]);
                connectedGroups[captain[edge.from]].forEach(i -> captain[i] = captain[edge.from]);
                addEdge(minGraph, edge.from, edge.to, edge.weight);
                connectedElements = connectedGroups[captain[edge.from]].size();
            }
        }
        return minGraph;
    }
}
