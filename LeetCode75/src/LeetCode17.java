import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

*/
public class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()){
            return ans;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backTrack(ans, map, 0, digits, new StringBuffer());
        return ans;
    }

    private void backTrack(List<String> ans, Map<Character, String> map, int i, String digits, StringBuffer stringBuffer) {
        if (i>=digits.length()){
            ans.add(stringBuffer.toString());
            return;
        }
        String str = map.get(digits.charAt(i));
        for (int j = 0; j < str.length(); j++) {
            stringBuffer.append(str.charAt(j));
            backTrack(ans,map,i+1,digits,stringBuffer);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }
}
