import java.util.List;

/**
 * @author pku-lyh
 * @Description 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * @date 2025/1/16 8:50
 */
public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == 1 && wordDict.contains(s.substring(j, i))) {
                    dp[i] = 1;
                }
            }
        }
        return dp[n] == 1;
    }
}
