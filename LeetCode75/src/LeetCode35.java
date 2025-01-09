/*给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

请必须使用时间复杂度为 O(log n) 的算法。*/
public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        int ans = divideSort(nums, target, 0, nums.length - 1);
        return ans;
    }

    private int divideSort(int[] nums, int target, int left, int right) {
        if (left > right) {
            return left;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return divideSort(nums, target, mid + 1, right);
        } else {
            return divideSort(nums, target, left, mid - 1);
        }
    }
}
