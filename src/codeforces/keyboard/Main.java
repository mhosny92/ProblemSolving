package  codeforces.keyboard;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// Solution
		String keyboard = "qwertyuiopasdfghjkl;zxcvbnm,./";
		String s = sc.nextLine();
		String word = sc.nextLine();
		StringBuilder newword = new StringBuilder();
		int temp = s.equals("R") ? -1 : 1;
		for (int i = 0; i < word.length(); i++) {
			newword.append(keyboard.charAt(keyboard.indexOf(word.charAt(i)) + temp));
		}
		out.println(newword.toString());
		// Solution end
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