/**
 * @author pku-lyh
 * @Description 描述
 * @date 2025/2/13 12:02
 */
public class LeetCode643 {
    public double findMaxAverage(int[] nums, int k) {
        double ans = 0;
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        ans = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            ans = Math.max(ans, sum);
        }
        return ans / k;
    }
}
