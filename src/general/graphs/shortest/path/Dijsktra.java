package general.graphs.shortest.path;

import general.graphs.Edge;
import general.graphs.Graph;
import general.graphs.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijsktra {

    public static List getShortestPath(Graph graph, int startVertex){
        int graphSize = graph.getVerticesSize();
        List<Integer> S = new ArrayList<>();
        int [] d = new int[graphSize];
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>();

        for (int i = 0; i < graphSize; i++) {
            if (i != startVertex) {
                d[i] = Integer.MAX_VALUE;
                pq.add(new Pair<>(new Integer(i), new Integer(d[i])));
            }
        }
        d[startVertex] = 0;
        pq.add(new Pair<>(new Integer(startVertex), new Integer(d[startVertex])));
        int val = 0;
        while (!pq.isEmpty()){
            Pair p = pq.poll();
            int u = p.getKey();
            int w = (Integer) p.getValue();
            val += w;
            S.add(u + 1);
            List<Edge> edges = graph.getVertexEdges(u);
            for (Edge e :
                    edges) {
                int dest = e.getDestination();
                if (d[dest] > d[u] + val){
                    d[dest] = d[u] + val;
                }
            }
        }


        return S;
    }

    public static void main(String[] args){
        int vertices = 5;
        Graph graph = new Graph(vertices, true);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 1, 4);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 4, 7);
        graph.addEdge(4, 3, 9);

        List result = getShortestPath(graph, 0);

        result.stream().forEach(v -> System.out.println(v));


    }
}
