package geeksforgeeks.amazon.fulfillment.builder;

import general.heaps.MinHeap;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = out = new PrintWriter(new BufferedOutputStream(System.out));
        //---------------------------------------- Solution ---------------------------
        int n = scanner.nextInt();
        BigInteger sum = new BigInteger("0");
        //MinHeap<Integer> heap = new MinHeap<>(Integer.class);
        BigInteger arr[] = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new BigInteger(scanner.next());
        }
        MinHeap<BigInteger> heap = new MinHeap<>(n, arr);
        while (heap.size() > 1) {
            BigInteger f = heap.poll();
            BigInteger s = heap.poll();
            BigInteger m = f.add(s);
            sum = sum.add(m);
            heap.add(m);
        }
        out.println(sum);
        //----------------------------------------    End   ----------------------------
        out.close();

    }
}
