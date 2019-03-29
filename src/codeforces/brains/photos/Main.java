package codeforces.brains.photos;


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// solution to problem http://codeforces.com/contest/43/problem/A
public class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        // Start writing your solution here. -------------------------------------
        int n = sc.nextInt(); int m = sc.nextInt();
        boolean blackAndWhite = true;
        for (int i = 0; i < n * m; i++) {
            String s = sc.next();
            if (!s.equals("B") && !s.equals("W") && !s.equals("G"))
                blackAndWhite = false;
        }
        if (blackAndWhite)
            out.println("#Black&White");
        else
            out.println("#Color");
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