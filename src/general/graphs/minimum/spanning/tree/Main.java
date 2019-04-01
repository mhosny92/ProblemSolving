package general.graphs.minimum.spanning.tree;

import general.graphs.Edge;
import general.graphs.Graph;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Main {
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
                if (e.getDestination() == vertexTwo) {
                    e.setWeight(weight);
                    break;
                }
            }
            // Update adj list weights for second vertex
            for (Edge e : vertexTwoEdges) {
                if (e.getDestination() == vertexOne) {
                    e.setWeight(weight);
                    break;
                }
            }
        }
        Edge[] primResult = Prim.getMST(graph);
        long totalWeight = 0;
        for (int i = 0; i < primResult.length; i++) {
            totalWeight += primResult[i].getWeight();
            out.println("Parent vertex: " + (primResult[i].getSource()+1) + " -> " + (primResult[i].getDestination()+1) + " weight: " + primResult[i].getWeight());
        }
        out.println("Total weight: " + totalWeight);
        totalWeight = 0;
        Edge[] kruskalResult = Kruskal.getMST(graph);
        for (int i = 0; i < kruskalResult.length; i++) {
            totalWeight += kruskalResult[i].getWeight();
            out.println("Parent vertex: " + (kruskalResult[i].getSource()+1) + " -> " + (kruskalResult[i].getDestination()+1) + " weight: " + kruskalResult[i].getWeight());
        }
        out.println("Total weight: " + totalWeight);
        out.close();
    }
}
