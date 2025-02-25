import java.util.ArrayList;
import java.util.List;

/**
 * @author pku-lyh
 * @Description 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * @date 2025/2/18 15:29
 */
public class LeetCode216 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        backtrack(ans, combine, k, n, 0, 1);
        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, List<Integer> combine, int k, int n, int sum, int i) {
        if (sum > n) {
            return;
        }
        if (k == 0 && sum == n) {
            ans.add(new ArrayList<>(combine));
        } else {
            for (int j = i; j < 10; j++) {
                combine.add(j);
                sum += j;
                backtrack(ans, combine, k - 1, n, sum, j + 1);
                sum -= j;
                combine.remove(combine.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        combinationSum3(3, 7);
    }
}
