package general.disjoint.set;


/*
Consider a situation with a number of persons and following tasks to be performed on them.

Add a new friendship relation, i.e., a person x becomes friend of another person y.
Find whether individual x is a friend of individual y (direct or indirect friend)

We are given 10 individuals say,
a, b, c, d, e, f, g, h, i, j

Following are relationships to be added.
a <-> b
b <-> d
c <-> f
c <-> i
j <-> e
g <-> j


Input:
10
a b c d e f g h i j
6
a b
b d
c f
c i
j e
g j
3
a d
c j
e b

 */

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static public void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int indivNumber = scanner.nextInt();
        String[] indiv = new String[indivNumber];
        DisjointSet disjointSet = new DisjointSet(indivNumber);
        Map<String, Integer> map= new HashMap<>();
        for (int i = 0; i < indivNumber; i++) {
            indiv[i] = scanner.next();
            map.put(indiv[i], i);
        }
        int relation = scanner.nextInt();
        for (int i = 0; i < relation; i++) {
            String src = scanner.next(); String dest = scanner.next();
            disjointSet.union(map.get(src), map.get(dest));
        }
        int testCase = scanner.nextInt();
        for (int i = 0; i < testCase; i++) {
            String src = scanner.next(); String dest = scanner.next();
            int srcSet = disjointSet.find(map.get(src));
            int destSet = disjointSet.find(map.get(dest));
            if (srcSet == destSet){
                out.println("Connected");
            }else {
                out.println("Disconnected");
            }
        }
        out.close();
    }
}
