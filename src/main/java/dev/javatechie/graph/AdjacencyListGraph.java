package dev.javatechie.graph;

import java.util.ArrayList;

public class AdjacencyListGraph<E extends Comparable<E>> {

    ArrayList<Vertex> vertices;

    public AdjacencyListGraph() {
        vertices = new ArrayList<>();
    }

    private class Vertex {
        E data;
        ArrayList<Vertex> adjacentVertices;

        public Vertex(final E vertex) {

        }
    }
}
