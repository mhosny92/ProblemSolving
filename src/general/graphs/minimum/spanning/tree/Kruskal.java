package general.graphs.minimum.spanning.tree;

import general.graphs.Edge;
import general.graphs.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskal {

    static int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    static void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    static boolean containsCycle(int[] parent, int src, int des) {
        int srcSet = find(parent, src);
        int desSet = find(parent, des);
        if (srcSet == desSet)
            return true;
        union(parent, src, des);
        return false;
    }

    public static Edge[] getMST(Graph graph) {
        int graphSize = graph.getVerticesSize();
        int[] parent = new int[graphSize];
        List<Edge> result = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < graphSize; i++) {
            parent[i] = -1;
            List<Edge> edgeList = graph.getVertexEdges(i);
            for (Edge e :
                    edgeList) {
                pq.offer(e);
            }
        }
        while (result.size() != graphSize - 1) {
            Edge e = pq.poll();
            if (!containsCycle(parent, e.getSource(), e.getDestination())) {
                result.add(e);
            }
        }


        return result.isEmpty() ? new Edge[1] : result.toArray(new Edge[result.size()]);
    }
}
