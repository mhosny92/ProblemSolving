package geeksforgeeks.amazon.assessment.cities;

class Edge {
    private int connectedVertex;
    private int weight;

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

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
