package games;

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
//		int n = sc.nextInt();
//		int l1[] = new int[n];
//		int l2[] = new int[n];
//		for (int i=0; i<n ;i++) {
//			l1[i] = sc.nextInt();
//			l2[i] = sc.nextInt();
//		}
//		int ans = 0;
//		for (int i=0; i<n; i++) {
//			for (int j=i+1; j<n; j++) {
//				if (l1[i] == l2[j] && l2[i] == l1[j]){
//					ans += 2;
//				} else if (l1[i] == l2[j] || l2[i] == l1[j]) {
//					ans++;
//				}
//			}
//		}
//		out.println(ans);
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