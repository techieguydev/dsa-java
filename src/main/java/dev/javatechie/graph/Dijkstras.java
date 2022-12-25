package dev.javatechie.graph;

public class Dijkstras {

    int k = 0;
    int minDist(int dist[], Boolean set[]) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for(int r = 0; r < k; r++) {
            if (set[r] == false && dist[r] <= min) {
                min = dist[r];
            }
        }
    }
}
