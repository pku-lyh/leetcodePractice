import java.util.ArrayList;
import java.util.List;

/**
 * @author pku-lyh
 * @Description 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
 * 子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * @date 2025/1/8 11:24
 */
public class LeetCode78 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backStrack(nums, 0);
        return res;
    }

    private void backStrack(int[] nums, int i) {
        res.add(new ArrayList<>(list));
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            backStrack(nums, j + 1);
            list.remove(list.size() - 1);
        }
    }
}
