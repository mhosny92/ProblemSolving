package codeforces.live.contests.round_551_d2.serval.and.bus;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        //----------------------- code begins -----------------------------------
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int index = -1; int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int rec = scanner.nextInt();
            int x = start;
            while (x < t)
                x += rec;
            if (x-t < min){
                min = x-t;
                index = i+1;
            }

        }
        out.println(index);
        //----------------------- code ends -------------------------------------
        out.close();
    }
}
