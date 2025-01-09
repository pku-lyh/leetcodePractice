import java.util.ArrayList;
import java.util.List;

/*数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。*/
public class LeetCode22 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backStrack(n, 0, 0, new StringBuffer());
        return res;
    }

    private void backStrack(int n, int lNum, int rNum, StringBuffer str) {
        if ((lNum == rNum) && lNum == n) {
            res.add(str.toString());
            return;
        }
        if (lNum > n || rNum > lNum) {
            return;
        }
        str.append('(');
        backStrack(n, lNum + 1, rNum, str);
        str.deleteCharAt(str.length() - 1);
        str.append(')');
        backStrack(n, lNum, rNum + 1, str);
        str.deleteCharAt(str.length() - 1);
    }
}
