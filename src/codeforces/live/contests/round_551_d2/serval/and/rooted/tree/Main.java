package codeforces.live.contests.round_551_d2.serval.and.rooted.tree;


import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        //----------------------- code begins -----------------------------------
        int n = scanner.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
            nodes[i].op = scanner.nextInt();
        }
        for (int i = 1; i < n; i++) {
            int parent = scanner.nextInt();
            nodes[parent-1].children.add(nodes[i]);
        }
        out.println(dfs(nodes[0], 1));
        //----------------------- code ends -------------------------------------
        out.close();
    }

    private static int dfs(Node node, int leafVal){
        if (node.children.size() == 0){
            node.val = leafVal;
            return leafVal + 1;
        }
        int current = 0;
        for (int i = 0; i < node.children.size(); i++) {
            current = node.op == 0? Math.min(current, leafVal) : Math.max(current, leafVal);
            leafVal = dfs(node.children.get(i), leafVal);
        }
        return current;
    }
}

class Node{
    public List<Node> children = new ArrayList<>();
    public int op;
    public int val;
}
