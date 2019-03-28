package serija.and.dema;

import java.io.*;
import java.util.*;

public class Main {
	/*
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// Start writing your solution here. -------------------------------------
		int n = sc.nextInt();
		int s = 0; int d = 0;
		boolean sTurn = true;
		List<Integer> arr = new ArrayList<Integer>();
		for (int i=0; i<n; i++) {
			arr.add(sc.nextInt());
		}
		for (int i=0; i<arr.size() ; i++) {
			Integer val = arr.get(i) > arr.get(arr.size()-1) ? arr.get(i): arr.get(arr.size()-1);
			arr.remove(val);
			i = -1;
			if (sTurn) {
				s += val;
			}else {
				d += val;
			}
			sTurn = !sTurn;
		}
		out.println(s + " " + d);
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