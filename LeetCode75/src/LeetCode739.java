import java.util.Stack;

/*给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。*/
public class LeetCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            ans[stack.pop()] = 0;
        }
        return ans;
    }
}
