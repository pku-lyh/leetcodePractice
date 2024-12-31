import java.util.HashMap;
import java.util.Map;

/*给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。*/
public class LeetCode3 {
    public static int lengthOfLongestSubstring(String s) {
        // 记录字符下标
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int ans = 0;
        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
