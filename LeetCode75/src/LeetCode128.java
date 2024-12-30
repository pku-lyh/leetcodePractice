import java.util.HashMap;
import java.util.Map;

/*给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。*/
public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            map.put(num, 1);
        }
        for (int num : nums) {
            if (!map.containsKey(num - 1)){
                int cur = num;
                int len = 1;
                while (map.containsKey(cur + 1)){
                    cur++;
                    len++;
                }
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}
