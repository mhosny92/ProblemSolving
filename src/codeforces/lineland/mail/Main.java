package lineland.mail;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// Start writing your solution here. -------------------------------------
		int n = sc.nextInt();
		int arr[] = new int [n];
		for (int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		int lowest = arr[0]; int highest = arr[n-1];
		out.println(Math.abs(arr[1] - lowest) + " " + Math.abs(highest - lowest));
		for (int i=1; i<n-1; i++) {
			int min = Math.min(Math.abs(arr[i] - arr[i-1]), Math.abs(arr[i+1] - arr[i]));
			int max = Math.max(Math.abs(arr[i] - lowest), Math.abs(highest - arr[i]));
			out.println(min + " " + max);
		}
		out.println(Math.abs(highest - arr[n-2]) + " " + Math.abs(highest - lowest));
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