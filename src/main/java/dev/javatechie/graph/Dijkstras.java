package dev.javatechie.graph;

/**
 * The type Dijkstras.
 */
public class Dijkstras {

    int k = 0;

    /**
     * Min dist int.
     *
     * @param dist the array dist
     * @param set  the set
     * @return the int
     */
    int minDist(int dist[], Boolean set[]) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for(int r = 0; r < k; r++) {
            if (set[r] == false && dist[r] <= min) {
                min = dist[r];
                min_index = r;
            }
        }
        return min_index;
    }

    /**
     * Print.
     *
     * @param dist the array of dist
     */
    void print(int dist[]) {
        System.out.println("Vertex \t\t Distance");
        for(int i = 0; i < k; i++) {
            System.out.println(i + " \t " + dist[i]);
        }
    }

    /**
     * Dijkstra.
     *
     * @param graph the array of graph
     * @param src   the src
     */
    void dijkstra(int graph[][], int src) {
        int dist[] = new int[k];
        Boolean set[] = new Boolean[k];
    }
}
