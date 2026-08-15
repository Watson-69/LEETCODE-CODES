import java.io.*;
import java.util.*;
public class codeforces {
    static final long MOD = 998244353;
    static final long G = 3; // Primitive root for 998244353

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long[] a = new long[n];
            long prodAll = 1;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
                prodAll = (prodAll * a[i]) % MOD;
            }

            if (n == 3) {
                // Direct shortcut for small cases to preserve speed
                long c1 = 0;
                for (int i = 0; i < n; i++) {
                    long sq = (a[i] * a[i]) % MOD;
                    for (int j = 0; j < n; j++) {
                        if (i != j) {
                            c1 = (c1 + sq * a[j]) % MOD;
                        }
                    }
                }
                long ans = 2 * 2 * (prodAll + c1 * power(2, MOD - 2) % MOD) % MOD;
                out.println((ans % MOD + MOD) % MOD);
                continue;
            }

            // Precompute factorials and central binomial coefficients
            long[] fact = new long[n + 1];
            fact[0] = 1;
            for (int i = 1; i <= n; i++)
                fact[i] = (fact[i - 1] * i) % MOD;

            // Generate intermediate bounded 2D polynomials
            Poly finalPoly = divideAndConquer(a, 0, n - 1);

            long sumK = 0;
            // Extract C_k where total z-power == n
            for (int k = 1; k <= n / 2; k++) {
                int u = n - 2 * k; // Since u + 2b = n and b = k
                long ck = finalPoly.get(u, k);

                long ncr = nCr(2 * k, k, fact);
                long invNcr = power(ncr, MOD - 2);
                long term = (ck * invNcr) % MOD;
                sumK = (sumK + term) % MOD;
            }

            long totalInner = (prodAll + sumK) % MOD;
            long ans = (2 * fact[n - 1] % MOD * totalInner) % MOD;
            out.println((ans % MOD + MOD) % MOD);
        }
        out.flush();
    }

    // Compact representation of the 2D triangular polynomial
    static class Poly {
        int len;
        long[][] coeff; // coeff[u][b] represents z^u * y^b

        Poly(int len) {
            this.len = len;
            this.coeff = new long[len + 1][];
            for (int u = 0; u <= len; u++) {
                coeff[u] = new long[(len - u) / 2 + 1];
            }
        }

        void set(int u, int b, long val) {
            if (u <= len && b <= (len - u) / 2) {
                coeff[u][b] = val;
            }
        }

        long get(int u, int b) {
            if (u <= len && b <= (len - u) / 2)
                return coeff[u][b];
            return 0;
        }
    }

    static Poly divideAndConquer(long[] a, int l, int r) {
        if (l == r) {
            Poly p = new Poly(2);
            p.set(0, 0, 1); // 1
            p.set(1, 0, a[l]); // a_i * z
            p.set(0, 1, (a[l] * a[l]) % MOD); // a_i^2 * z^2 * y (mapped as b=1)
            return p;
        }
        int mid = (l + r) >> 1;
        Poly left = divideAndConquer(a, l, mid);
        Poly right = divideAndConquer(a, mid + 1, r);
        return multiply2D(left, right);
    }

    static Poly multiply2D(Poly p1, Poly p2) {
        int newLen = p1.len + p2.len;
        Poly res = new Poly(newLen);

        // Perform row-by-row 1D NTT multiplication to handle the 2D grid efficiently
        for (int u1 = 0; u1 <= p1.len; u1++) {
            for (int u2 = 0; u2 <= p2.len; u2++) {
                int targetU = u1 + u2;
                long[] row1 = p1.coeff[u1];
                long[] row2 = p2.coeff[u2];

                long[] prodRow = multiply1D(row1, row2);
                for (int b = 0; b < prodRow.length; b++) {
                    if (b <= (newLen - targetU) / 2) {
                        res.coeff[targetU][b] = (res.coeff[targetU][b] + prodRow[b]) % MOD;
                    }
                }
            }
        }
        return res;
    }

    static long[] multiply1D(long[] a, long[] b) {
        int n = 1;
        while (n < a.length + b.length)
            n <<= 1;
        long[] fa = Arrays.copyOf(a, n);
        long[] fb = Arrays.copyOf(b, n);

        ntt(fa, false);
        ntt(fb, false);
        for (int i = 0; i < n; i++)
            fa[i] = (fa[i] * fb[i]) % MOD;
        ntt(fa, true);

        return Arrays.copyOf(fa, a.length + b.length - 1);
    }

    static void ntt(long[] a, boolean invert) {
        int n = a.length;
        for (int i = 1, j = 0; i < n; i++) {
            int bit = n >> 1;
            for (; (j & bit) != 0; bit >>= 1)
                j ^= bit;
            j ^= bit;
            if (i < j) {
                long temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        for (int len = 2; len <= n; len <<= 1) {
            long wlen = power(G, (MOD - 1) / len);
            if (invert)
                wlen = power(wlen, MOD - 2);
            for (int i = 0; i < n; i += len) {
                long w = 1;
                for (int j = 0; j < len / 2; j++) {
                    long u = a[i + j], v = (a[i + j + len / 2] * w) % MOD;
                    a[i + j] = (u + v < MOD ? u + v : u + v - MOD);
                    a[i + j + len / 2] = (u - v >= 0 ? u - v : u - v + MOD);
                    w = (w * wlen) % MOD;
                }
            }
        }
        if (invert) {
            long ninv = power(n, MOD - 2);
            for (int i = 0; i < n; i++)
                a[i] = (a[i] * ninv) % MOD;
        }
    }

    static long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1)
                res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }

    static long nCr(int n, int r, long[] fact) {
        if (r < 0 || r > n)
            return 0;
        long num = fact[n];
        long den = (fact[r] * fact[n - r]) % MOD;
        return (num * power(den, MOD - 2)) % MOD;
    }

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

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
    }
}
