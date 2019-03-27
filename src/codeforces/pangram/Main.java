package pangram;

import java.io.*;
import java.util.*;
 
 
public class Main{
   public static void main(String[] args) {
      MyScanner sc = new MyScanner();
      out = new PrintWriter(new BufferedOutputStream(System.out));
      // Solution
      int n = sc.nextInt();
      if (n < 26)
    	  out.println("NO");
      else {
    	  String s = sc.nextLine();
    	  s = s.toLowerCase();
    	  boolean arr[] = new boolean [26];
    	  for (int i=0; i<n ;i++) {
    		  arr[s.charAt(i)-'a'] = true;
    	  }
    	  boolean alltrue = true;
    	  for (int i=0; i<26; i++) {
    		  if (!arr[i]) {
    			  alltrue = false;
    			  break;
    		  }
    	  }
    	  if (alltrue)
    		  out.println("YES");
    	  else out.println("NO");
      }
      
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