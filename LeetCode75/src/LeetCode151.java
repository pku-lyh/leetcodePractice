import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author pku-lyh
 * @Description 描述
 * @date 2025/2/12 14:14
 */
public class LeetCode151 {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> wordList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            }else {
                wordList.add(sb.toString());
                sb.setLength(0);
                while (i < s.length() && s.charAt(i+1) == ' ') {
                    i++;
                }
            }
        }
        wordList.add(sb.toString());
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
