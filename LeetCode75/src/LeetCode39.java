import java.util.ArrayList;
import java.util.List;

/**
 * @author pku-lyh
 * @Description 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * @date 2025/1/8 11:50
 */
public class LeetCode39 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backStrack(candidates, 0, 0, target);
        return res;
    }
    private void backStrack(int[] nums, int i, int sum, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum < target) {
            for (int j = i; j < nums.length; j++) {
                list.add(nums[j]);
                backStrack(nums, j, sum + nums[j], target);
                list.remove(list.size() - 1);
            }
        }
    }
}
