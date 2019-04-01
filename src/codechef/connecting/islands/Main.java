package codechef.connecting.islands;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    static public void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int islandsNumber = scanner.nextInt();
        int queries = scanner.nextInt();
        SubSet[] subSets = new SubSet[islandsNumber];
        for (int i = 0; i < islandsNumber; i++) {
            subSets[i] = new SubSet(i, 1);
        }
        for (int i = 0; i < queries; i++) {
            int operation = scanner.nextInt();
            int src = scanner.nextInt() - 1;
            int dest = scanner.nextInt() - 1;
            if (operation == 0){
                union(subSets, src, dest);
            } else {
                out.println(find(subSets, src) == find(subSets, dest)? "Yes" :"No");
            }
        }

        out.close();
    }

    static class SubSet {
        int parent;
        int rank;

        public SubSet(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    static public int find (SubSet[] subSets, int element){
        if (subSets[element].parent == element)
            return element;
        int result = find(subSets, subSets[element].parent);
        subSets[element].parent = result;
        return result;
    }

    static public void union(SubSet[] subSets, int src, int dest){
        int srcRoot = find(subSets, src);
        int destRoot = find(subSets, dest);

        if (srcRoot == destRoot)
            return;

        int srcRank = subSets[src].rank;
        int destRank = subSets[dest].rank;

        if (srcRank < destRank){
            subSets[srcRoot].parent = destRoot;
        } else if (destRank < srcRank){
            subSets[destRoot].parent = srcRoot;
        } else {
            subSets[srcRoot].parent = destRoot;
            subSets[destRoot].rank ++;
        }
    }
}
