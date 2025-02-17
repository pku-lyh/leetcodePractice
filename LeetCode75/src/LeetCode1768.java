/*给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。

返回 合并后的字符串 。*/

public class LeetCode1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0;
        int n1 = word1.length();
        int n2 = word2.length();
        while (i < n1 && j < n2) {
            ans.append(word1.charAt(i++));
            ans.append(word2.charAt(j++));
        }
        if (j < n2) {
            ans.append(word2, j, n1);
        } else if(i < n1){
            ans.append(word1, i, n1);
        }
        return ans.toString();
    }
}
