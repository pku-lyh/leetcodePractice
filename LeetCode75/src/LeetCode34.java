/*给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。*/
public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = findLeft(nums, target, 0, n - 1);
        int right = findRight(nums, target, 0, n - 1);
        return new int[]{left, right};
    }

    private int findRight(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            if (mid == nums.length - 1 || nums[mid + 1] != target) {
                return mid;
            } else {
                return findRight(nums, target, mid + 1, right);
            }
        } else if (nums[mid] > target) {
            return findRight(nums, target, left, mid - 1);
        } else {
            return findRight(nums, target, mid + 1, right);
        }
    }

    private int findLeft(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            if (mid == 0 || nums[mid - 1] != target) {
                return mid;
            } else {
                return findLeft(nums, target, left, mid - 1);
            }
        } else if (nums[mid] > target) {
            return findLeft(nums, target, left, mid - 1);
        } else {
            return findLeft(nums, target, mid + 1, right);
        }
    }
}
