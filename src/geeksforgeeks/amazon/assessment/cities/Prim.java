package geeksforgeeks.amazon.assessment.cities;

import general.heaps.Heap;
import general.heaps.MinHeap;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {

    public static Pair<Integer, Integer>[] getMST(Graph graph) {
        int verticesSize = graph.getVerticesSize(); // contains the number of vertices in the graph.
        boolean[] mst = new boolean[verticesSize];// boolean array that contains visited vertices as true.
        Pair<Integer, Integer>[] result = (Pair<Integer, Integer>[]) Array.newInstance(Pair.class, verticesSize);
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // priority queue to store vertices and their weight.
        int[] keys = new int[verticesSize]; // key array to keep track of keys.
        // Initialize mst array to false and keys array to Integer.MAX_VALUE.
        for (int i = 0; i < verticesSize; i++) {
            mst[i] = false;
            keys[i] = Integer.MAX_VALUE;
        }
        // Assign first node in graph with value 0
        keys[0] = 0;
        pq.add(new Pair<>(0, 0));
        result[0] = new Pair<>(-1, 0);

        while (!pq.isEmpty()) {
            Integer vertex = pq.poll().getKey(); // Parent vertex
            mst[vertex] = true; // Mark vertex as visited
            List<Edge> vertexEdges = graph.getVertexEdges(vertex); // Get vertex edges
            // Loop through the edges.
            for (int i = 0; i < vertexEdges.size(); i++) {
                int connectedVertex = vertexEdges.get(i).getConnectedVertex();
                int weight = vertexEdges.get(i).getWeight();
                if (!mst[connectedVertex] && keys[connectedVertex] > weight) { // Check if the vertex is not processed before the weight is less than keys[connectedVertex]
                    pq.add(new Pair(connectedVertex, weight));
                    result[connectedVertex] = new Pair<>(vertex, weight);
                    keys[connectedVertex] = weight;
                }

            }
        }
        return result;
    }

}

