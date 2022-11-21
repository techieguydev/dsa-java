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

        public boolean removeAdjacentVertex(final E to) {
            for(int i = 0; i < adjacentVertices.size(); i++) {
                if(adjacentVertices.get(i).data.compareTo(to) == 0) {
                    adjacentVertices.remove(i);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean removeEdge(final E from, final E to) {
        Vertex fromV = null;
        for(Vertex v : vertices) {
            if(from.compareTo(v.data) == 0) {
                fromV = v;
                break;
            }
        }
        if(fromV == null) {
            return false;
        }
        return fromV.removeAdjacentVertex(to);
    }

    public boolean addEdge(final E from, final E to) {
        Vertex fromV = null;
        Vertex toV = null;
        for(Vertex v : vertices) {
            if(from.compareTo(v.data) == 0) {
                fromV = v;
            } else if (to.compareTo(v.data) == 0) {
                toV = v;
            }
            if(fromV != null && toV != null) {
                break;
            }
        }
        if(fromV == null) {
            fromV = new Vertex(from);
            vertices.add(fromV);
        }
        if(toV == null) {
            toV = new Vertex(to);
            vertices.add(toV);
        }
        return fromV.addAdjacentVertex(toV);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for(Vertex v : vertices) {
            sb.append("Vertex: ");
            sb.append(v.data);
            sb.append("\n");
            sb.append("Adjacent vertices: ");
            for(Vertex v2: v.adjacentVertices) {
                sb.append(v2.data);
                sb.append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

class Graphs {
    public static void main(String[] args) {
        final AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        assert graph.addEdge(1, 2);
        assert graph.addEdge(1, 5);
        assert
    }
}
