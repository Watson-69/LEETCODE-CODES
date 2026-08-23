import java.io.*;
import java.util.*;
public class drwoningporblem {

    static class FenwickTree {
        int n;
        int[] tree;

        FenwickTree(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void add(int i, int delta) {
            for (; i <= n; i += i & -i) {
                tree[i] += delta;
            }
        }

        int query(int i) {
            int sum = 0;
            for (; i > 0; i -= i & -i) {
                sum += tree[i];
            }
            return sum;
        }

        int query(int l, int r) {
            if (l > r) return 0;
            return query(r) - query(l - 1);
        }   
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc, out);
        }

        out.flush();
    }

    static void solve(FastScanner sc, PrintWriter out) throws IOException {
        int n = sc.nextInt();

        long[] a = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextLong();
        }

        // Step 1: Compute Alternating Prefix Sums
        long[] P = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                P[i] = P[i - 1] + a[i];
            } else {
                P[i] = P[i - 1] - a[i];
            }
        }

        // Step 2: Coordinate Compression on Alternating Prefix Sums
        List<Long> vals = new ArrayList<>();
        for (long v : P) vals.add(v);
        Collections.sort(vals);

        List<Long> comp = new ArrayList<>();
        for (long v : vals) {
            if (comp.isEmpty() || comp.get(comp.size() - 1) != v) {
                comp.add(v);
            }
        }
        vals = comp;

        int M = vals.size();
        FenwickTree bitEven = new FenwickTree(M);
        FenwickTree bitOdd = new FenwickTree(M);

        bitEven.add(Collections.binarySearch(vals, P[0]) + 1, 1);

        long ans = 0;

        // Step 3: Iterate through finding valid odd/even bounds
        for (int r = 1; r <= n; r++) {
            int idx = Collections.binarySearch(vals, P[r]) + 1;

            if (r % 2 == 1) {
                // Need even k = l - 1 such that P_r > P_k
                ans += bitEven.query(1, idx - 1);
                bitOdd.add(idx, 1);
            } else {
                // Need odd k = l - 1 such that P_k > P_r
                ans += bitOdd.query(idx + 1, M);
                bitEven.add(idx, 1);
            }
        }

        out.println(ans);
    }
}
