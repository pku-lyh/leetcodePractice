/**
 * @author pku-lyh
 * @Description 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号
 * 子串的长度。
 * @date 2025/1/17 13:08
 */
public class LeetCode32 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i < n; i++) {
            // 动态规划下标和字符串下标相差1
            int dpNum = i + 1;
            if (s.charAt(i - 1) == '(') {
                if (s.charAt(i) == ')') {
                    dp[dpNum] = dp[dpNum - 2] + 2;
                } else {
                    dp[dpNum] = 0;
                }
            } else {
                if (s.charAt(i) == ')') {
                    if (i - dp[dpNum - 1] - 1 >= 0 && s.charAt(i - dp[dpNum - 1] - 1) == '(') {
                        dp[dpNum] = dp[dpNum - 1] + dp[dpNum - dp[dpNum - 1] - 2] + 2;
                    }
                } else {
                    dp[dpNum] = 0;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n + 1; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "(()())";
        LeetCode32 leetCode32 = new LeetCode32();
        System.out.println(leetCode32.longestValidParentheses(s));
    }
}
