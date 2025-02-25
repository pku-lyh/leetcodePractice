import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author pku-lyh
 * @Description 描述
 * @date 2025/2/24 21:11
 */
public class LeetCode2542 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums2.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        // 建立一个最大堆
        Arrays.sort(ids,(i, j) ->nums2[j] - nums2[i]);
        long num = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            num +=nums1[ids[i]];
            queue.offer(nums1[ids[i]]);
        }
        long max = num * nums2[ids[k - 1]];
        for (int i = k; i < n; i++) {
            int x = nums1[ids[i]];
            if (x > queue.peek()){
                queue.offer(x);
                num += x - queue.poll();
                max = Math.max(max, num * nums2[ids[i]]);
            }
        }
        return max;
    }
}
