/*给你一个整数数组峰值元素是指其值严格大于左右相邻值的元素。

给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。

你可以假设 nums[-1] = nums[n] = -∞ 。

你必须实现时间复杂度为 O(log n) 的算法来解决此问题。*/
public class LeetCode162 {
    public int findPeakElement(int[] nums) {
        if (nums.length==1){
            return 0;
        }
        int n = nums.length;
        int i = 0, j = n - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (mid == 0){
                if (nums[mid] > nums[mid + 1]){
                    return mid;
                }else {
                    i = mid + 1;
                }
            }else if (mid == n-1){
                if (nums[mid] > nums[mid - 1]){
                    return mid;
                }else {
                    j = mid - 1;
                }
            }else if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            }else if (nums[mid - 1] >= nums[mid]){
                j = mid - 1;
            }else {
                i = mid + 1;
            }
        }
        return 0;
    }
}
