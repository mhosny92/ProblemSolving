package geeksforgeeks.amazon.pythagorean.triplet;
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int testCases = scanner.nextInt();
        for (int t=0; t<testCases; t++){
            int arrSize = scanner.nextInt();
            int[] arr = new int[arrSize];
            int[] sq = new int[arrSize];
            Set<Integer> set = new HashSet();
            boolean found = false;
            for (int i = 0; i < arrSize; i++) {
                arr[i] = scanner.nextInt();
                sq[i] = arr[i] * arr[i];
                set.add(sq[i]);
            }
            for (int i=0; i<arrSize; i++){
                if (!found){
                    for (int j = i+1; j < arrSize; j++){
                        int temp = sq[i] + sq[j];
                        if (temp <= 1000000 && set.contains(temp)){
                            found = true;
                            break;
                        }
                    }
                } else break;
            }
            out.println(found?"Yes":"No");
        }
        out.close();
    }
}