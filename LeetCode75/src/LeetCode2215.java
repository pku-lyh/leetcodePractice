import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，请你返回一个长度为 2 的列表 answer ，其中：

answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
注意：列表中的整数可以按 任意 顺序返回。*/
public class LeetCode2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (!map1.containsKey(nums2[i])) {
                if (!ans2.contains(nums2[i])) {
                    ans2.add(nums2[i]);
                }
            }
            map2.put(nums2[i], nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (!map2.containsKey(nums1[i])) {
                if (!ans1.contains(nums1[i])) {
                    ans1.add(nums1[i]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(ans1);
        ans.add(ans2);
        return ans;
    }
}
