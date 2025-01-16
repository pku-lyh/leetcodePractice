/**
 * @author pku-lyh
 * @Description 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
 * 子数组
 * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * @date 2025/1/16 9:51
 */
public class LeetCode152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int sum = 1;
        int res = Integer.MIN_VALUE;
        //如果有偶数个负数，一次遍历就可得到最大值
        for (int i = 0; i < n; i++) {
            sum *= nums[i];
            res = Math.max(res, sum);
            if (sum == 0) {
                sum = 1;
            }
        }
        //如果有奇数个负数，则需要再反向遍历一次
        sum = 1;
        for (int i = n - 1; i >= 0; i--) {
            sum *= nums[i];
            res = Math.max(res, sum);
            if (sum == 0) {
                sum = 1;
            }
        }
        return res;
    }
}
