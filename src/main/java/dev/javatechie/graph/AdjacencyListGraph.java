package dev.javatechie.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListGraph<E extends Comparable<E>> {

    List<Vertex> vertices;

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

                }
            }
        }
    }
}
