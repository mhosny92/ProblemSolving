package geeksforgeeks.amazon.strings.levenshtein.edit.distance;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class GFG {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int l1 = scanner.nextInt(); int l2 = scanner.nextInt();
            String s1 = scanner.next();
            String s2 = scanner.next();

            int[][] lev = new int[l1+1][l2+1];
            for (int i = 0; i < s1.length()+1; i++) {
                for (int j = 0; j < s2.length()+1; j++) {
                    if(Math.min(i,j) == 0){
                        lev[i][j] = Math.max(i, j);
                    }else {
                        int temp = lev[i-1][j-1] +(s1.charAt(i-1) != s2.charAt(j-1) ?  1 : 0);
                        lev[i][j] = Math.min(Math.min(lev[i-1][j]+1 , lev[i][j-1]+1), temp);
                    }
                }
            }
            out.println(lev[l1][l2]);

        }

        out.close();
    }
}
