/**
 * @author pku-lyh
 * @Description 给你一个字符串 s，找到 s 中最长的回文子串。
 * @date 2025/1/18 12:26
 */
public class LeetCode5 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String res = s.substring(0,1);
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 2; i <= n; i++) {
            for (int left = 0; left < n - i + 1; left++) {
                int right = left + i - 1;
                if (s.charAt(left) == s.charAt(right)){
                    if (i == 2){
                        dp[left][right] = true;
                        res = s.substring(left, right + 1);
                    }else {
                        dp[left][right] = dp[left + 1][right - 1];
                        if (dp[left][right] && i > res.length()){
                            res = s.substring(left, right + 1);
                        }
                    }
                }
            }
        }
        return res;
    }
}
