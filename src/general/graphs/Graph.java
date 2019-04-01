package general.graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<List<Edge>> adj;

    public Graph(int vertices) {
        adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int v1, int v2, int weight) {
        adj.get(v1).add(new Edge(v1, v2, weight));
        adj.get(v2).add(new Edge(v2, v1, weight));
    }

    public List<Edge> getVertexEdges(int vertex) {
        return adj.get(vertex);
    }

    public int getVerticesSize() {
        return this.adj.size();
    }
}