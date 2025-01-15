import java.util.*;

/**
 * @author pku-lyh
 * @Description 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 * @date 2025/1/15 8:18
 */
public class LeetCode763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, Math.max(map.getOrDefault(c, 0), i));
        }
        int left = -1;
        int right = map.get(s.charAt(0));
        for (int i = 0; i < n; i++) {
            right = Math.max(right, map.get(s.charAt(i)));
            if (i == right || i == n - 1) {
                res.add(right - left);
                left = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(new LeetCode763().partitionLabels(s));
    }
}
