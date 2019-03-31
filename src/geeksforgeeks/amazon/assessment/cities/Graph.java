package geeksforgeeks.amazon.assessment.cities;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<List<Edge>> adj = new ArrayList<>();

    public void addEdge(int v1, int v2, int weight) {
        if (adj.get(v1) == null)
            adj.add(v1, new ArrayList<>());
        adj.get(v1).add(new Edge(v2, weight));
    }

    public List<Edge> getVertexEdges(int vertex) {
        return adj.get(vertex);
    }

    public int getVerticesSize() {
        return this.adj.size();
    }
}