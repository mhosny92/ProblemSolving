package geeksforgeeks.amazon.negative.weight.cycle;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int testCase = scanner.nextInt();
        while (testCase-- > 0) {
            int vertices = scanner.nextInt();
            int edges = scanner.nextInt();
            Graph graph = new Graph(vertices+1, false);
            for (int i = 0; i < edges; i++) {
                int src = scanner.nextInt();
                int des = scanner.nextInt();
                int weight = scanner.nextInt();
                graph.addEdge(src, des, weight);
            }
            try {
                List result = getShortestPath(graph, 0);
                out.println("0");
            } catch (IllegalStateException e) {
                out.println("1");
            }
        }
        out.close();
    }

    static public List<Integer> getShortestPath(Graph graph, int startVertex) {
        int graphSize = graph.getVerticesSize();
        List<Integer> S = new ArrayList<>();
        Integer[] d = new Integer[graphSize];

        for (int i = 0; i < graphSize; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        d[startVertex] = 0;
        List<Edge> graphEdges = graph.getGraphEdges(startVertex);
        for (int i = 1; i < graphSize; i++) {
            for (Edge e :
                    graphEdges) {
                if (d[e.getSource()] != Integer.MAX_VALUE && d[e.getDestination()] > (d[e.getSource()] + e.getWeight())) {
                    d[e.getDestination()] = d[e.getSource()] + e.getWeight();
                }
            }
        }

        for (Edge e :
                graphEdges) {
            if (d[e.getDestination()] > d[e.getSource()] + e.getWeight()) {
                throw new IllegalStateException();
            }
        }
        S.addAll(Arrays.asList(d));
        return S;
    }
}

class Graph {
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

class Edge implements Comparable<Edge>{
    private int source;
    private int destination;
    private int weight;

    public Edge() {
    }

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
