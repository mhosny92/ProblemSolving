package codeforces.live.contests.round_551_d2.serval.and.parenthesis.sequence;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        //----------------------- code begins -----------------------------------
        int n = scanner.nextInt();
        if (n % 2 == 0){
            String p = scanner.next();
            StringBuilder b = new StringBuilder();
            Character lastAppended = '(';
            for (int i = 0; i <n-1; i++) {
                if (p.charAt(i) == '?'){
                    if (!correctSeq(b.toString()+lastAppended)){
                        b.append(lastAppended);
                        lastAppended = lastAppended == '(' ? ')' : '(';
                    } else {
                        lastAppended = lastAppended == '(' ? ')' : '(';
                        if (!correctSeq(b.toString() + lastAppended)){
                            b.append(lastAppended);
                            lastAppended = lastAppended == '(' ? ')' : '(';
                        } else {
                            break;
                        }
                    }
                } else{
                    b.append(p.charAt(i));
                }
            }

            if(correctSeq(b.toString()+ '(')){
                out.println(b.append('(').toString());
            } else if (correctSeq(b.toString() + ')')){
                out.println(b.append(')').toString());
            } else {
                out.println(":(");
            }
        }else {
            out.println(":(");
        }
        //----------------------- code ends -------------------------------------
        out.close();
    }

    private static boolean correctSeq(String s){
        boolean ans = false;
        if (s.charAt(0) == ')')
            return ans;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push('(');
            } else {
                stack.pop();
            }
        }
        if (stack.empty())
            ans = true;
        return ans;
    }

}
