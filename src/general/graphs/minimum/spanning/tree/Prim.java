package general.graphs.minimum.spanning.tree;



import general.graphs.Edge;
import general.graphs.Graph;
import general.graphs.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {
    /*
    * Returns an array of Pair that contains parent node and weight of connecting edge.
    * */
    public static Edge[] getMST(Graph graph) {
        int verticesSize = graph.getVerticesSize(); // contains the number of vertices in the graph.
        boolean[] mst = new boolean[verticesSize];// boolean array that contains visited vertices as true.
        Edge[] result = new Edge[verticesSize-1];
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>(); // priority queue to store vertices and their weight.
        int[] keys = new int[verticesSize]; // key array to keep track of keys.
        // Initialize mst array to false and keys array to Integer.MAX_VALUE.
        for (int i = 1; i < verticesSize; i++) {
            keys[i] = Integer.MAX_VALUE;
        }
        // Assign first node in graph with value 0
        keys[0] = 0;
        pq.add(new Pair(new Integer(0), new Integer(0)));

        while (!pq.isEmpty()) {
            Integer vertex = pq.poll().getKey(); // Parent vertex
            mst[vertex] = true; // Mark vertex as visited
            List<Edge> vertexEdges = graph.getVertexEdges(vertex); // Get vertex edges
            // Loop through the edges.
            for (int i = 0; i < vertexEdges.size(); i++) {
                Integer destination = vertexEdges.get(i).getDestination();
                Integer weight = vertexEdges.get(i).getWeight();
                if (!mst[destination] && keys[destination] > weight) { // Check if the vertex is not processed before the weight is less than keys[connectedVertex]
                    pq.add(new Pair(destination, weight));
                    result[destination-1] = vertexEdges.get(i);
                    keys[destination] = weight;
                }

            }
        }
        return result;
    }

}

