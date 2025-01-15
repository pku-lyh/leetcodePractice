/**
 * @author pku-lyh
 * @Description 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * @date 2025/1/15 8:11
 */
public class LeetCode45 {
    public int jump(int[] nums) {
        int res = 0;
        int max = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > right){
                res++;
                right = max;
            }
            max = Math.max(max, i + nums[i]);
        }
        return res;
    }
}
