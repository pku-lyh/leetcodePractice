/**
 * @author pku-lyh
 * @Description 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * @date 2025/1/13 8:37
 */
public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mid = (m + n) / 2;
        if ((m + n) % 2 == 0) {
            return (findKthElement(nums1, nums2, mid) + findKthElement(nums1, nums2, mid + 1)) / 2.0;
        } else {
            return findKthElement(nums1, nums2, mid + 1);
        }
    }
    //***********************************************************************
    // / 查找两个数组的第k小的数
    private double findKthElement(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int index1 = 0;
        int index2 = 0;
        while (true){
           if (index1 == m){
               return nums2[index2 + k - 1];
           }
           if (index2 == n){
               return nums1[index1 + k - 1];
           }
           if (k == 1){
               return Math.min(nums1[index1], nums2[index2]);
           }
           int half = k / 2;
           int newIndex1 = Math.min(index1 + half, m) - 1;
           int newIndex2 = Math.min(index2 + half, n) - 1;
           if (nums1[newIndex1] <= nums2[newIndex2]){
               k -= (newIndex1 - index1 + 1);
               index1 = newIndex1 + 1;
           } else {
               k -= (newIndex2 - index2 + 1);
               index2 = newIndex2 + 1;
           }
        }
    }

    public static void main(String[] args) {
        int[] nums = {};
        int[] nums2 = {1};
        System.out.println(new LeetCode4().findMedianSortedArrays(nums, nums2));
    }
}
