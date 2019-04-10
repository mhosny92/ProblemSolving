package geeksforgeeks.amazon.stock.span;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class GFG {
    static public void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int arrSize = scanner.nextInt();
            int[] arr = new int[arrSize];
            int[] sol = new int[arrSize];
            for (int i = 0; i < arrSize; i++) {
                arr[i] = scanner.nextInt();
            }

            for (int i = arrSize-1; i >= 0; i--) {
                int cnt = 1;
                for (int j = i-1; j >= 0; j--) {
                    if (arr[i] > arr[j])
                        cnt++;
                    else break;
                }
                sol[i] = cnt;
            }
            for (int i = 0; i < arrSize; i++) {
                out.print(sol[i] + " ");
            }
            out.println();
        }

        out.close();
    }
}
