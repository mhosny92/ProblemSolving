package team.olympiad;

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
//		List<Integer> one = new ArrayList<Integer>();
//		List<Integer> two = new ArrayList<Integer>();
//		List<Integer> three = new ArrayList<Integer>();
//		for (int i=0; i<n ;i++) {
//			int temp = sc.nextInt();
//			if (temp == 1) {
//				one.add(i+1);
//			} else if (temp == 2) {
//				two.add(i+1);
//			}else {
//				three.add(i+1);
//			}
//		}
//		int min = Math.min(one.size(), two.size());
//		min = Math.min(min, three.size());
//		out.println(min);
//		for (int i=0; i<min; i++) {
//			out.println(one.get(i) + " " + two.get(i) + " " + three.get(i));
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