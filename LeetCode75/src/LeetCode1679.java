import java.util.HashMap;
import java.util.Map;

/**
 * @author pku-lyh
 * @Description 给你一个整数数组 nums 和一个整数 k 。
 *
 * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 *
 * 返回你可以对数组执行的最大操作数。
 * @date 2025/2/13 11:56
 */
public class LeetCode1679 {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = map.getOrDefault(k - nums[i], 0);
            if (num > 0) {
                res++;
                map.put(k - nums[i], num - 1);
            }else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return res;
    }
}
