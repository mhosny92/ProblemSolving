package codeforces.olesya.and.rodion;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        // Start writing your solution here. -------------------------------------
        int n = sc.nextInt(); int t = sc.nextInt();
        BigInteger b = new BigInteger("10");
        BigInteger m = new BigInteger(t + "");
        b = b.pow(n-1);
        while (!b.mod(m).equals(new BigInteger("0"))){
            b = b.add(new BigInteger("1"));
        }
        String s = b.toString();
        if (s.length() != n)
            out.println("-1");
        else
            out.println(b.toString());
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