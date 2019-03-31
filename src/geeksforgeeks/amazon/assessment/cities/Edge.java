package geeksforgeeks.amazon.assessment.cities;

class Edge {
    int connectedVertex;
    int weight;

    public Edge(int vertex, int weight) {
        this.connectedVertex = vertex;
        this.weight = weight;
    }


    public int getConnectedVertex() {
        return connectedVertex;
    }

    public int getWeight() {
        return weight;
    }
}
