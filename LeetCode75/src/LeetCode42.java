/*给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。*/
public class LeetCode42 {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int ans = 0;
        int max = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        for (int i = 1; i < n; i++) {
            ans += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return ans;
    }
}
