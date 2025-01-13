import java.util.Stack;

/**
 * @author pku-lyh
 * @Description 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * @date 2025/1/13 15:57
 */
public class LeetCode155 {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> helpStack;

        public MinStack() {
            stack = new Stack<>();
            helpStack = new Stack<>();
            helpStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            helpStack.push(Math.min(helpStack.peek(), val));
            stack.push(val);
        }

        public void pop() {
            stack.pop();
            helpStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return helpStack.peek();
        }
    }
}
