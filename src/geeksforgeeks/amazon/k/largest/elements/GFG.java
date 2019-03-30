package geeksforgeeks.amazon.k.largest.elements;

import general.heaps.Heap;
import general.heaps.MaxHeap;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class GFG {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int testCase = scanner.nextInt();
        for (int t = 0; t < testCase; t++) {
            int size = scanner.nextInt(); int k = scanner.nextInt();
            Heap<Integer> heap = new MaxHeap<>(Integer.class);
            for (int i = 0; i < size; i++) {
                heap.add(scanner.nextInt());
            }
            for (int i = 0; i < k-1; i++) {
                out.print(heap.poll()+ " ");
            }
            out.println(heap.poll());
        }
        out.close();
    }
}
