package geeksforgeeks.amazon.next.larger.element;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        //---------------------------------------- Solution ---------------------------
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            BigInteger arr[] = new BigInteger[size];
            BigInteger sol[] = new BigInteger[size];
            Stack<Integer> s = new Stack<>();
            arr[0] = new BigInteger(scanner.next());
            s.push(0);
            for (int i = 1; i < size; i++) {
                arr[i] = new BigInteger(scanner.next());
                while (!s.empty() && arr[i].compareTo(arr[s.peek()]) > 0) {
                    sol[s.pop()] = arr[i];
                }
                s.push(i);
            }
            while (!s.empty()) {
                sol[s.pop()] = new BigInteger("-1");
            }
            for (int i = 0; i < size; i++) {
                out.print(sol[i] == null ? "-1 " : (sol[i].toString() + " "));
            }
            out.println();
        }
        //----------------------------------------    End   ----------------------------
        out.close();
    }
}
