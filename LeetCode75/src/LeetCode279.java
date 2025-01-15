/**
 * @author pku-lyh
 * @Description 描述
 * @date 2025/1/15 9:11
 */
public class LeetCode279 {
    public int numSquares(int n) {
        int res = 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i ; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
