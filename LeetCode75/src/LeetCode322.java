import java.util.Arrays;

/**
 * @author pku-lyh
 * @Description 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 * @date 2025/1/16 8:39
 */
public class LeetCode322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        Arrays.sort(coins);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j<coins.length && coins[j] <= i ; j++) {
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        System.out.println(new LeetCode322().coinChange(coins, amount));
    }
}
