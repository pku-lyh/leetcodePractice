/**
 * @author pku-lyh
 * @Description 描述
 * @date 2025/1/16 10:19
 */
public class LeetCode416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        if (sum % 2 != 0 || max > sum / 2) {
            return false;
        }
        int target = sum / 2;
        boolean[]dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
