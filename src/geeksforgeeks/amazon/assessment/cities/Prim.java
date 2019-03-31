package geeksforgeeks.amazon.assessment.cities;

import general.heaps.Heap;
import general.heaps.MinHeap;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prim {
    Graph graph;
    // set that contains visited vertices.
    Set<Integer> mst = new HashSet<>();
    // hashmap that contains initial key value with values set to inf.
    Heap<Pair> minHeap = new MinHeap<>(Pair.class);

    public Prim(Graph graph) {
        this.graph = graph;
    }

    public Set<Integer> getMST() {
        // Assign first node in graph with value 0
        minHeap.add(new Pair<>(0, 0));
        // Assign other nodes with value INF
        for (int i = 1; i < graph.getVerticesSize(); i++) {
            minHeap.add(new Pair<>(i, Integer.MAX_VALUE));
        }
        while (mst.size() != graph.getVerticesSize()) {
            Integer vertex = minHeap.poll().getKey();
            mst.add(vertex);
            List<Edge> vertexEdges = graph.getVertexEdges(vertex);
            for (int i = 0; i < vertexEdges.size(); i++) {

            }
        }
        return mst;
    }

}

