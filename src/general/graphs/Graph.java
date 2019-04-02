package general.graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<List<Edge>> adj;
    boolean undirected;

    public Graph(int vertices, boolean undirected) {
        adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
        this.undirected = undirected;
    }

    public void addEdge(int v1, int v2, int weight) {
        adj.get(v1).add(new Edge(v1, v2, weight));
        if (this.undirected)
            adj.get(v2).add(new Edge(v2, v1, weight));
    }

    public List<Edge> getVertexEdges(int vertex) {
        return adj.get(vertex);
    }

    public List<Edge> getGraphEdges(Integer src) {
        List<Edge> allEdges = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            allEdges.addAll(adj.get(i));
        }
        if(src != null){
            allEdges.removeAll(adj.get(src));
            allEdges.addAll(0, adj.get(src));
        }
        return allEdges;
    }

    public int getVerticesSize() {
        return this.adj.size();
    }
}