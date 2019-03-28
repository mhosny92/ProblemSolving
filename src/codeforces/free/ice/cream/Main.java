package free.ice.cream;

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
//		int n = sc.nextInt(), kids = 0;
//		long init = sc.nextLong();
//		for (int i=0; i<n; i++) {
//			String s = sc.next();
//			long val = sc.nextLong();
//			if (s.equals("+")) {
//				init += val;
//			}else {
//				if (init >= val) {
//					init -= val;
//				}else {
//					kids++;
//				}
//			}
//		}
//		out.println(init + " " +kids);
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