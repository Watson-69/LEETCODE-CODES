public class distinct {
    class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();   // approach for qotd
        
        // dp[j] = number of ways to form t[0..j-1] from s processed so far
        int[] dp = new int[n + 1];
        dp[0] = 1; // empty t can be formed in exactly one way
        
        for (int i = 1; i <= m; i++) {
            // iterate backwards to avoid using the current character more than once
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        
        return dp[n];
    }
}
}
