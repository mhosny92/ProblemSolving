package codeforces.anton.and.danik;

import java.io.*;
import java.util.*;
 
 
public class Main{
	/*
   public static void main(String[] args) {
      MyScanner sc = new MyScanner();
      out = new PrintWriter(new BufferedOutputStream(System.out));
      
      // Start writing your solution here. -------------------------------------
   
      int n = sc.nextInt();
      int anton = 0;
      String input = sc.nextLine();
      for (int i=0; i<n; i++) {
    	  if (input.charAt(i) == 'A')
    		  anton++;
      }
      if (anton*2 == n)
    	  out.println("Friendship");
      else if (anton*2 > n)
    	  out.println("Anton");
      else out.println("Danik");
      // Stop writing your solution here. -------------------------------------
      out.close();
   }
	*/
     

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