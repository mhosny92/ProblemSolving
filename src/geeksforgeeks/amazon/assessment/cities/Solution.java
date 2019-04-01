package geeksforgeeks.amazon.assessment.cities;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        int numTotalAvailableCites = 5;
        int numTotalAvailableRoads = 7;
        List<List<Integer>> roadsAvailable = new ArrayList<List<Integer>>() {{
            add(new ArrayList<Integer>() {{
                add(1);
                add(2);
            }});
            add(new ArrayList<Integer>() {{
                add(1);
                add(4);
            }});
            add(new ArrayList<Integer>() {{
                add(2);
                add(3);
            }});
            add(new ArrayList<Integer>() {{
                add(2);
                add(4);
            }});
            add(new ArrayList<Integer>() {{
                add(2);
                add(5);
            }});
            add(new ArrayList<Integer>() {{
                add(3);
                add(5);
            }});
            add(new ArrayList<Integer>() {{
                add(4);
                add(5);
            }});
        }};
        int numRoadsToBeRepaired = 7;
        List<List<Integer>> costRoadsToBeRepaired = new ArrayList<List<Integer>>() {{
            add(new ArrayList<Integer>() {{
                add(1);
                add(2);
                add(2);
            }});
            add(new ArrayList<Integer>() {{
                add(1);
                add(4);
                add(6);
            }});
            add(new ArrayList<Integer>() {{
                add(2);
                add(3);
                add(3);
            }});
            add(new ArrayList<Integer>() {{
                add(2);
                add(4);
                add(8);
            }});
            add(new ArrayList<Integer>() {{
                add(2);
                add(5);
                add(5);
            }});
            add(new ArrayList<Integer>() {{
                add(3);
                add(5);
                add(7);
            }});
            add(new ArrayList<Integer>() {{
                add(4);
                add(5);
                add(9);
            }});
        }};
        System.out.println(getMinimumCostToRepair(numTotalAvailableCites, numTotalAvailableRoads, roadsAvailable, numRoadsToBeRepaired, costRoadsToBeRepaired));
    }

    static int getMinimumCostToRepair(int numTotalAvailableCites,
                                      int numTotalAvailableRoads,
                                      List<List<Integer>> roadsAvailable,
                                      int numRoadsToBeRepaired,
                                      List<List<Integer>> costRoadsToBeRepaired) {
        int result = 0;
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < numTotalAvailableCites; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < numTotalAvailableRoads; i++) {
            int v1 = roadsAvailable.get(i).get(0) - 1;
            int v2 = roadsAvailable.get(i).get(1) - 1;
            adjList.get(v1).add(new Edge(v2, 0));
            adjList.get(v2).add(new Edge(v1, 0));
        }
        for (int i = 0; i < numRoadsToBeRepaired; i++) {
            int v1 = costRoadsToBeRepaired.get(i).get(0) - 1;
            int v2 = costRoadsToBeRepaired.get(i).get(1) - 1;
            int w = costRoadsToBeRepaired.get(i).get(2);
            // get v1 vertices and update them.
            List<Edge> edgeList = adjList.get(v1);
            for (int j = 0; j < edgeList.size(); j++) {
                if (edgeList.get(j).getConnectedVertex() == v2) {
                    edgeList.get(j).setWeight(w);
                    break;
                }
            }
            edgeList = adjList.get(v2);
            for (int j = 0; j < edgeList.size(); j++) {
                if (edgeList.get(j).getConnectedVertex() == v1) {
                    edgeList.get(j).setWeight(w);
                    break;
                }
            }
        }

        boolean[] mst = new boolean[numTotalAvailableCites];
        int[] keys = new int[numTotalAvailableCites];
        PriorityQueue<Pair> pq = new PriorityQueue();
        Pair[] res = (Pair[]) Array.newInstance(Pair.class, numTotalAvailableCites);
        for (int i = 0; i < numTotalAvailableCites; i++) {
            keys[i] = Integer.MAX_VALUE;
        }
        keys[0] = 0;
        pq.add(new Pair(0, 0));
        res[0] = new Pair(-1, 0);

        while (!pq.isEmpty()) {
            int vertex = pq.poll().getKey();
            mst[vertex] = true;
            List<Edge> edgeList = adjList.get(vertex);
            for (Edge e :
                    edgeList) {
                if (!mst[e.getConnectedVertex()] && keys[e.getConnectedVertex()] > e.getWeight()) {
                    keys[e.getConnectedVertex()] = e.getWeight();
                    res[e.getConnectedVertex()] = new Pair(vertex, e.getWeight());
                    pq.add(new Pair(e.getConnectedVertex(), e.getWeight()));
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            result += res[i].getValue();
        }
        return result;
    }
}

class Pair implements Comparable<Pair> {
    private int key;
    private int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Pair o) {
        return this.value - o.value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class Edge {
    private int connectedVertex;
    private int weight;

    public Edge(int connectedVertex, int weight) {
        this.connectedVertex = connectedVertex;
        this.weight = weight;
    }

    public int getConnectedVertex() {
        return connectedVertex;
    }

    public void setConnectedVertex(int connectedVertex) {
        this.connectedVertex = connectedVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
