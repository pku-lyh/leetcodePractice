/*给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。

说明：你不能倾斜容器。*/
public class LeetCode11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int ans = 0;
        int left = 0, right = n - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            // 为什么要这样写呢？
            // 因为如果移动较高的指针，那么容器的高度不会增加，容器的宽度会减少，所以容器的面积一定会减少
            // 如果移动较低的指针，那么容器的高度可能会增加，容器的宽度可能会减少，所以容器的面积可能会增加
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return ans;
    }
}
