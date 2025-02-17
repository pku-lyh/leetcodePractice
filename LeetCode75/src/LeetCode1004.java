/**
 * @author pku-lyh
 * @Description 描述
 * @date 2025/2/13 18:20
 */
public class LeetCode1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int res = 0;
        while (right < n) {
            if (nums[right] == 1) {
                right++;
            }else if (nums[right] == 0){
                if (k == 0){
                    res = Math.max(res, right - left);
                    while (left < right && nums[left] == 1) {
                        left++;
                    }
                    left++;
                    k++;
                }else {
                    k--;
                    right++;
                }
            }
        }
        return Math.max(res, right - left);
    }
}
