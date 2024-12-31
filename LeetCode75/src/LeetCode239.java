import java.util.Deque;
import java.util.LinkedList;

/*给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回 滑动窗口中的最大值 。*/
public class LeetCode239 {
    // 单调队列,队头永远是最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (deque.isEmpty()) {
                deque.offerLast(i);
            } else {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
        }
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            if (deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            if (deque.isEmpty()) {
                deque.offerLast(i);
            } else {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
