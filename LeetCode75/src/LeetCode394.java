import java.util.Stack;

/**
 * @author pku-lyh
 * @Description 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * @date 2025/1/13 16:30
 */
public class LeetCode394 {
    public String decodeString(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ']') {
                while (stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                stack.pop();
                String str = sb.toString();
                StringBuffer count  = new StringBuffer();
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    count.append(stack.pop());
                }
                int cnt = Integer.parseInt(count.reverse().toString());
                for (int j = 1; j < cnt; j++) {
                    sb.append(str);
                }
                str = sb.toString();
                for (int j = str.length() - 1; j >= 0; j--) {
                    stack.push(str.charAt(j));
                }
                sb = new StringBuilder();
            } else {
                stack.push(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(new LeetCode394().decodeString("3[a]2[c]"));
    }
}
