import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。

元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。*/
public class LeetCode345 {
    public String reverseVowels(String s) {
        List<Character> aa = Arrays.asList('a', 'e', 'i', 'o', 'u','U','A','E','I','O');
        List<Character> ch = new ArrayList<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (aa.contains(s.charAt(i))) {
                ch.add(s.charAt(i));
            }
        }
        int b = 0;
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (aa.contains(s.charAt(i))) {
                res.append(ch.get(b++));
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
