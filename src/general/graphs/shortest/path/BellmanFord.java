package general.graphs.shortest.path;

import general.graphs.Edge;
import general.graphs.Graph;
import general.graphs.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BellmanFord {

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


    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices, false);
        graph.addEdge(0, 1, -1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 1, 1);
        graph.addEdge(4, 3, -3);

        List result = getShortestPath(graph, 0);

        result.stream().forEach(v -> System.out.println(v));
    }
}
