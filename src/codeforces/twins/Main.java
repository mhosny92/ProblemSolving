package twins;

import java.io.*;
import java.util.*;
 
 
public class Main{
   public static void main(String[] args) {
      MyScanner sc = new MyScanner();
      out = new PrintWriter(new BufferedOutputStream(System.out));
      // Solution
      int n = sc.nextInt();
      List<Integer> list = new ArrayList<Integer>();
      int totalsum = 0;
      for (int i=0; i<n; i++) {
    	  list.add(sc.nextInt());
    	  totalsum += list.get(list.size()-1);
      }
      Collections.sort(list, Comparator.reverseOrder());
      
      int greedy = 0; int cnt = 0;
      while (greedy <= totalsum) {
    	  greedy += list.get(cnt);
    	  totalsum -= list.get(cnt);
    	  cnt++;
      }
      out.println(cnt);
      // Solution end
      out.close();
   }

   //-----------PrintWriter for faster output---------------------------------
   public static PrintWriter out;
      
   //-----------MyScanner class for faster input----------
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
 
      String nextLine(){
          String str = "";
	  try {
	     str = br.readLine();
	  } catch (IOException e) {
	     e.printStackTrace();
	  }
	  return str;
      }

   }
   //--------------------------------------------------------
}