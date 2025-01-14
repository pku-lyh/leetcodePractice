/**
 * @author pku-lyh
 * @Description 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * @date 2025/1/14 14:40
 */
public class LeetCode55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int right = 0;
        for (int i = 0; i <= right; i++) {
            if (right >= n -1){
                return true;
            }
            right = Math.max(right, i + nums[i]);
        }
        return false;
    }
}
