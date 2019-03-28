package  codeforces.forming.teams;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// This problem solves the Bipartite graph property.
public class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        // Start writing your solution here. -------------------------------------
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Boolean> visited = new ArrayList<Boolean>();
        List<Integer> team = new ArrayList<Integer>();
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        Integer cyclesNumber = 0;
        for (int i = 0; i < n; i++) {
            visited.add(false);
            l.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < k; i++) {
            int t1 = sc.nextInt(), t2 = sc.nextInt();
            l.get(t1 - 1).add(t2 - 1);
            l.get(t2 - 1).add(t1 - 1);
        }
        for (int i = 0; i < l.size(); i++) {
            if (!visited.get(i)) {
                Ref<Integer> cnt = new Ref<>(0);
                if (dfs(l, visited, i, -1, cnt)){
                    cyclesNumber += cnt.value % 2 == 1? 1 : 0;
                }
            }
        }
        System.out.println((n - cyclesNumber) % 2 == 1 ? cyclesNumber+1 : cyclesNumber);
        // Stop writing your solution here. -------------------------------------
        out.close();
    }

    private static boolean dfs(List<List<Integer>> l, List<Boolean> visited, int current, int parent, Ref<Integer> count) {
        if (visited.get(current))
            return true;
        visited.set(current, true);
        for (int j = 0; j < l.get(current).size(); j++) {
            if (l.get(current).get(j) != parent) {
                count.value++;
                if (dfs(l, visited, l.get(current).get(j), current, count))
                    return true;
            }
        }
        return false;
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

class Ref<T>
{
    public T value;
    public Ref(T v){
        value = v;
    }
}