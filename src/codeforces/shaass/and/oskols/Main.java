package shaass.and.oskols;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
//	public static void main(String[] args) {
//		MyScanner sc = new MyScanner();
//		out = new PrintWriter(new BufferedOutputStream(System.out));
//		// Start writing your solution here. -------------------------------------
//		int wiresCnt = sc.nextInt();
//		int[] wire = new int[wiresCnt];
//		for (int i = 0; i < wiresCnt; i++) {
//			wire[i] = sc.nextInt();
//		}
//		int m = sc.nextInt();
//		for (int i = 0; i < m; i++) {
//			int wireNumber = sc.nextInt();
//			int killed = sc.nextInt();
//			if (wireNumber - 2 >= 0)
//				wire[wireNumber - 2] += killed - 1;
//			if (wireNumber < wiresCnt)
//				wire[wireNumber] += wire[wireNumber - 1] - killed;
//			wire[wireNumber - 1] = 0;
//		}
//		for (int i=0; i<wiresCnt; i++) {
//			out.println(wire[i]);
//		}
//		// Stop writing your solution here. -------------------------------------
//		out.close();
//	}

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