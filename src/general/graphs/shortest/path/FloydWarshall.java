package general.graphs.shortest.path;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
2
2
0 25
INF 0
3
0 1 43
1 0 6
INF INF 0
////////////
2
2
0 25
10000000 0
3
0 1 43
1 0 6
10000000 10000000 0

 */
public class FloydWarshall {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        
        int testCase = scanner.nextInt();

        for (int t = 0; t < testCase; t++) {
            int graphSize = scanner.nextInt();
            int[][] graph = new int[graphSize][graphSize];

            for (int m = 0; m < graphSize; m++) {
                for (int n = 0; n < graphSize; n++) {
                    String str = scanner.next();
                    graph[m][n] = str.equals("INF") ? Integer.MAX_VALUE : (Integer.parseInt(str) < 501? Integer.parseInt(str) : Integer.MAX_VALUE);
                }
            }


            int[][] d = new int[graphSize][graphSize];
            int[][] p = new int[graphSize][graphSize];

            for (int i = 0; i < graphSize; i++) {
                for (int j = 0; j < graphSize; j++) {
                    d[i][j] = graph[i][j] == 0 ? Integer.MAX_VALUE : graph[i][j];
                    p[i][j] = j;
                }
            }

            for (int i = 0; i < graphSize; i++) {
                d[i][i] = 0;
                p[i][i] = i;
            }

            for (int k = 0; k < graphSize; k++) {
                for (int i = 0; i < graphSize; i++) {
                    for (int j = 0; j < graphSize; j++) {
                        if (d[i][k] != Integer.MAX_VALUE && d[k][j] != Integer.MAX_VALUE && d[i][j] > d[i][k] + d[k][j]){
                            d[i][j] = d[i][k] + d[k][j];
                            p[i][j] = p[i][k];
                        }
                    }
                }
            }

            for (int i = 0; i < graphSize; i++) {
                for (int j = 0; j < graphSize; j++) {
                    out.print(d[i][j] == Integer.MAX_VALUE? "INF " : d[i][j] + " ");
                }
                out.println();
            }
/*            System.out.println();
            for (int i = 0; i < graphSize; i++) {
                for (int j = 0; j < graphSize; j++) {
                    System.out.print((p[i][j]+1) + " ");
                }
                System.out.println();
            }
            Integer[] path = findPath(p, 0, 1);
            Arrays.stream(path).forEach(v -> System.out.print(v + " "));*/
        }
        out.close();
    }
    public static Integer[] findPath(int[][] next, int src, int des){
        List<Integer> path = new ArrayList<>();
        int u = src;
        path.add(src);
        while (src != des){
            src = next[src][des];
            path.add(src);
        }
        return path.toArray(new Integer[path.size()]);
    }
}
