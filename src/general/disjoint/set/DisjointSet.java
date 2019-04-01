package general.disjoint.set;

public class DisjointSet {

    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find (int element){
        if (parent[element] == element)
            return element;
        int result = find(parent[element]);
        parent[element] = result;
        return result;
    }

    public void union(int src, int dest){
        int srcRoot = find(src);
        int destRoot = find(dest);

        if (srcRoot == destRoot)
            return;

        int srcRank = rank[src];
        int destRank = rank[dest];

        if (srcRank < destRank){
            parent[srcRoot] = destRoot;
        } else if (destRank < srcRank){
            parent[destRoot] = srcRoot;
        } else {
            parent[srcRoot] = destRoot;
            rank[destRoot] ++;
        }
    }
}
