package geeksforgeeks.amazon.assessment.cities;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int totalAvailableCities = scanner.nextInt();
        Graph graph = new Graph(totalAvailableCities);
        int totalAvailableRoads = scanner.nextInt();
        for (int i = 0; i < totalAvailableRoads; i++) {
            int vertexOne = scanner.nextInt();
            int vertexTwo = scanner.nextInt();
            graph.addEdge(vertexOne - 1, vertexTwo - 1, 0);
        }
        int roadsToBeRepaired = scanner.nextInt();
        for (int i = 0; i < roadsToBeRepaired; i++) {
            int vertexOne = scanner.nextInt() - 1;
            int vertexTwo = scanner.nextInt() - 1;
            int weight = scanner.nextInt();
            List<Edge> vertexOneEdges = graph.getVertexEdges(vertexOne);
            List<Edge> vertexTwoEdges = graph.getVertexEdges(vertexTwo);
            // Update adj list weights for first vertex
            for (Edge e : vertexOneEdges) {
                if (e.getConnectedVertex() == vertexTwo) {
                    e.setWeight(weight);
                    break;
                }
            }
            // Update adj list weights for second vertex
            for (Edge e : vertexTwoEdges) {
                if (e.getConnectedVertex() == vertexOne) {
                    e.setWeight(weight);
                    break;
                }
            }
        }
        Pair[] result = Prim.getMST(graph);
        long totalWeight = 0;
        for (int i = 0; i < result.length; i++) {
            totalWeight += result[i].getValue().longValue();
            out.println("Parent vertex: " + result[i].getKey() + " -> " + i + " weight: " + result[i].getValue());
        }
        out.println("Total weight: " + totalWeight);
        out.close();
    }
}
