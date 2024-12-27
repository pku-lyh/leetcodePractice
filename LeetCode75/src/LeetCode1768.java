/*给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。

返回 合并后的字符串 。*/

public class LeetCode1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int length = Math.min(word1.length(), word2.length());
        for(int i =0;i<length;i++){
            ans.append(word1.charAt(i));
            ans.append(word2.charAt(i));
        }
        if(word1.length() == length){
            for(int j =length;j<word2.length();j++){
                ans.append(word2.charAt(j));
            }
        }else{
            for(int j =length;j<word1.length();j++){
                ans.append(word1.charAt(j));
            }
        }
        return ans.toString();
    }
}
