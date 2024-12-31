/*给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。

子数组是数组中元素的连续非空序列。*/
public class LeetCode560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        // 前缀和
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (preSum[j] - preSum[i] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
