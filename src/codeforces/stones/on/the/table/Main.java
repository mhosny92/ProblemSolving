package  codeforces.stones.on.the.table;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// Start writing your solution here. -------------------------------------
		int n = sc.nextInt();
		String s = sc.next();
		int i=0; int ans = 0;
		char prev = 'a';
		do {
			char current = s.charAt(i);
			if (current == prev)
				ans++;
			prev = current;
			i++;
		}while(i<s.length());
		out.println(ans);
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