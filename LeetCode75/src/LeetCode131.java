/*给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是
回文串
 。返回 s 所有可能的分割方案。*/
import java.util.ArrayList;
import java.util.List;

public class LeetCode131 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTrack(s, 0);
        return res;
    }

    private void backTrack(String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
            } else {
                continue;
            }
            backTrack(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int begin, int end) {
        for (int i = begin, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
