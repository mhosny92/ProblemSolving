package geeksforgeeks.amazon.element.that.appears.once.where.every.element.occurs.twice;

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int testCases = scanner.nextInt();
        for (int t=0; t<testCases; t++){
            int size = scanner.nextInt();
            int ans = 0;
            for(int i=0; i < size; i++){
                int temp = scanner.nextInt();
                ans ^= temp;
            }
            out.println(ans + "");
        }
        out.close();
    }
}