package codeforces.caseof.the.zeros.and.ones;


import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.Stream;

// solution to problem http://codeforces.com/contest/556/problem/A
public class Main {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// Start writing your solution here. -------------------------------------
        int n = sc.nextInt();
        String s = sc.nextLine();
        long ones = s.chars().filter(c -> c == '1').count();
        long zeros = s.length() - ones;

        out.println(s.length() - (Math.min(zeros, ones) * 2));
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