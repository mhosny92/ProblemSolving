package geeksforgeeks.amazon.save.ironman;
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int testCases = sc.nextInt();
        sc.nextLine();
        for (int t=0; t<testCases; t++){
            String s = sc.nextLine();
            s = s.toLowerCase();
            StringBuilder b = new StringBuilder();
            for(int i=0; i<s.length(); i++){
                if (Character.isLetterOrDigit(s.charAt(i))){
                    b.append(s.charAt(i));
                }
            }
            int end=b.length()-1;
            boolean pal = true;
            for (int start=0; start<b.length()/2; start++){
                if (b.charAt(start) != b.charAt(end)){
                    pal = false;
                    break;
                }
                end--;
            }
            out.println(pal?"YES":"NO");
        }
        out.close();
    }
}