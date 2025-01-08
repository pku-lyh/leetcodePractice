import java.util.ArrayList;
import java.util.List;

/**
 * @author pku-lyh
 * @Description 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @date 2025/1/8 11:16
 */
public class LeetCode46 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        backStrack(list, nums, 0);
        return res;
    }

    private void backStrack( List<Integer> list, int[] nums, int i) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (list.contains(nums[j])){
                continue;
            }
            list.add(nums[j]);
            backStrack(list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
