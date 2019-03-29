package geeksforgeeks.amazon.fulfillment.builder;

import general.heaps.MinHeap;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public  static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = out = new PrintWriter(new BufferedOutputStream(System.out));
        //---------------------------------------- Solution ---------------------------
        int n = scanner.nextInt();
        long sum = 0;
        //MinHeap<Integer> heap = new MinHeap<>(Integer.class);
        Integer arr[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        MinHeap<Integer> heap = new MinHeap<>(n, arr);
        while(heap.size() > 1) {
            int f = heap.poll();
            int s = heap.poll();
            int m = f+s;
            sum += m;
            heap.add(m);
        }
        out.println(sum);
        //----------------------------------------    End   ----------------------------
        out.close();

    }
}
