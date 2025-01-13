import java.util.Arrays;
import java.util.Stack;

/**
 * @author pku-lyh
 * @Description 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * @date 2025/1/13 17:15
 */
public class LeetCode84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                right[stack.pop()] = i;
            }
            if (stack.isEmpty()){
                left[i] = -1;
                stack.push(i);
            } else {
                left[i] = stack.peek();
                stack.push(i);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,5,6,2,3};
        System.out.println(new LeetCode84().largestRectangleArea(nums));
    }
}
