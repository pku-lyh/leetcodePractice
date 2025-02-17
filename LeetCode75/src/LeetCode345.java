/*给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。

元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。*/
public class LeetCode345 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
       int i = 0, j = s.length() - 1;
       while (i < j) {
           while (i < s.length() && !isVowel(chars[i])) {
               i++;
           }
           while (j >= 0 && !isVowel(chars[j])) {
               j--;
           }
           if (i < j) {
               swap(chars, i, j);
               i++;
               j--;
           }
       }
       return new String(chars);
    }

    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
