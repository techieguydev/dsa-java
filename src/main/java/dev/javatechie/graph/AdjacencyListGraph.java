package dev.javatechie.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListGraph<E extends Comparable<E>> {

    List<Vertex> vertices;

    /**
     * Instantiates a new Adjacency list graph.
     */
    public AdjacencyListGraph() {
        vertices = new ArrayList<>();
    }

    private class Vertex {
        E data;
        List<Vertex> adjacentVertices;

        public Vertex(final E data) {
            this.data = data;
            adjacentVertices = new ArrayList<>();
        }

        public boolean addAdjacentVertex(final Vertex to) {
            for(final Vertex vertex : adjacentVertices) {
                if(vertex.data.compareTo(to.data) == 0) {
                    return false;
                }
            }
            return adjacentVertices.add(to);
        }

        public void removeAdjacentVertex(final E to) {

        }
    }
}
