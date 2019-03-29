package codeforces.football;

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
        int n = sc.nextInt();
        List<String> scores = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            scores.add(sc.nextLine());
        }
        long team1 = scores.parallelStream().filter(s -> s.equals(scores.get(0))).count();
        long team2 = scores.size() - team1;
        if (team1 > team2){
            out.println(scores.get(0));
        } else {
            out.println(scores.parallelStream().distinct().filter(s -> !s.equals(scores.get(0))).findFirst().get());
        }
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