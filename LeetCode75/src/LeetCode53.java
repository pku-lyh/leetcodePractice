/*给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

子数组
是数组中的一个连续部分。*/
public class LeetCode53 {
    // 动态规划
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        // dp[i]表示以nums[i]结尾的最大子数组和
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
