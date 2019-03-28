package codeforces.translation;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        // Start writing your solution here. -------------------------------------
        String s = sc.nextLine();
        String t = sc.nextLine();

        if (s.length() != t.length())
            out.println("NO");
        else {
            boolean same = true;
            int i=0; int j=s.length()-1;
            while(i != s.length()){
                if (s.charAt(i) != t.charAt(j)){
                    out.println("NO");
                    same = false;
                    break;
                }
                i++;
                j--;
            }
            if (same){
                out.println("YES");
            }
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