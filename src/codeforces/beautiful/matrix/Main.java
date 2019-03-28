package beautiful.matrix;

import java.io.*;
import java.util.*;

public class Main {
	/*
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));

		// Start writing your solution here. -------------------------------------

		final int size = 5;
		int row = 0, col = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int temp = sc.nextInt();
				if (temp == 1) {
					row = i + 1;
					col = j + 1;
				}
			}
		}
		int ans = Math.abs(row-3) + Math.abs(col-3);
		out.println(ans);

		// Stop writing your solution here. -------------------------------------
		out.close();
	}
	*/
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