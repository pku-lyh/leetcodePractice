/**
 * @author pku-lyh
 * @Description 描述
 * @date 2025/1/14 8:39
 */
public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        buildMaxHeap(nums, n);
        for (int i = n - 1; i > nums.length - k; i--) {
            swap(nums, i, 0);
            n--;
            maxHeapify(nums, 0, n);
        }
        return nums[0];
    }

    private void buildMaxHeap(int[] nums, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, i, n);
        }
    }

    private void maxHeapify(int[] nums, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < n && nums[left] > nums[max]) {
            max = left;
        }
        if (right < n && nums[right] > nums[max]) {
            max = right;
        }
        if (max != i) {
            swap(nums, i, max);
            maxHeapify(nums, max, n);
        }
    }

    private void swap(int[] nums, int i, int max) {
        int temp = nums[i];
        nums[i] = nums[max];
        nums[max] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        new LeetCode215().findKthLargest(nums, 2);
    }
}
