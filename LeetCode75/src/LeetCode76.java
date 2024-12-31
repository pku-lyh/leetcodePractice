import java.util.HashMap;
import java.util.Map;

public class LeetCode76  {
    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return "";
        }
        for (int i = 0; i < n; i++) {
            ori.put(t.charAt(i), ori.getOrDefault(t.charAt(i), 0) + 1);
        }
        int minLength = Integer.MAX_VALUE;
        int valid = 0;
        int start = -1;
        int left = 0, right = 0;
        while (right < m) {
            char c = s.charAt(right);
            if (ori.containsKey(c)) {
                cnt.put(c, cnt.getOrDefault(c, 0) + 1);
                //如果cnt.get(c) == ori.get(c)说明c字符已经匹配完毕
                if (cnt.get(c).equals(ori.get(c))) {
                    valid++;
                }
            }
            // 说明已经找到一个可行解，尝试优化这个可行解
            while (valid == ori.size()) {
                if (right - left + 1 < minLength) {
                    start = left;
                    minLength = right - left + 1;
                }
                char d = s.charAt(left);
                if (ori.containsKey(d)) {
                    //如果cnt.get(d) == ori.get(d) - 1说明d字符即将不匹配,因为cnt中的d字符可能比ori中的d字符多
                    if (cnt.get(d).equals(ori.get(d))) {
                        valid--;
                    }
                    cnt.put(d, cnt.get(d) - 1);
                }
                left++;
            }
            right++;
        }
        return start == -1 ? "" : s.substring(start, start + minLength);
    }
}
