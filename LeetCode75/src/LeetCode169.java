/**
 * @author pku-lyh
 * @Description 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @date 2025/1/18 12:51
 */
public class LeetCode169 {
    public int majorityElement(int[] nums) {
        int num = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (num == 0){
                res = nums[i];
            }else {
                if (res == nums[i]){
                    num++;
                }else {
                    num--;
                }
            }
        }
        return res;
    }
}
