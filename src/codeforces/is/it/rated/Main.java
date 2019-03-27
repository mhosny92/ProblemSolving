package is.it.rated;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.StringTokenizer;


// my solution to problem http://codeforces.com/contest/807/problem/A

public class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        // Start writing your solution here. -------------------------------------
        int n = sc.nextInt();
        List<Integer> l = new ArrayList<>();
        int d = 0; // difference
        for (int i=0; i<n; i++){
            int b = sc.nextInt(); int a = sc.nextInt();
            l.add(a);
            d += Math.abs(a-b);
        }
        boolean sorted = l.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()).equals(l);

        if (d == 0 && sorted)
            out.println("maybe");
        else if (d == 0)
            out.println("unrated");
        else out.println("rated");

        // Stop writing your solution here. -------------------------------------
        out.close();
    }
    // -----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    // -----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
    // --------------------------------------------------------
}
