import java.util.ArrayList;
import java.util.List;

/*给定两个字符串 s 和 p，找到 s 中所有 p 的
异位词
 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。*/
public class LeetCode438 {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        if (m < n) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int differ = 0;
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[p.charAt(i) - 'a']++;
            cnt[s.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                differ++;
            }
        }
        if (differ == 0) {
            res.add(0);
        }
        for (int i = 0; i < m - n; i++) {
            int j = i + n;
            if (cnt[s.charAt(j) - 'a'] == 1) {
                differ--;
            } else if (cnt[s.charAt(j) - 'a'] == 0) {
                differ++;
            }
            cnt[s.charAt(j) - 'a']--;
            if (cnt[s.charAt(i) - 'a'] == -1) {
                differ--;
            } else if (cnt[s.charAt(i) - 'a'] == 0) {
                differ++;
            }
            cnt[s.charAt(i) - 'a']++;
            if (differ == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "baa";
        String p = "aa";
        LeetCode438 solution = new LeetCode438();
        System.out.println(solution.findAnagrams(s, p));
    }
}
