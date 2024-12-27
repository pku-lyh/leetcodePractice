public class LeetCode912 {
    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return nums;
        }
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[nums.length];
        int n = left;
        int i = left, j = mid+1;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]){
                temp[n++] = nums[i++];
            }else {
                temp[n++] = nums[j++];
            }
        }
        if (i>mid){
            while (j<=right){
                temp[n++] = nums[j++];
            }
        }else {
            while (i<=mid){
                temp[n++] = nums[i++];
            }
        }
        while (left<=right){
            nums[left] = temp[left];
            left++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,1,1,2,0,0};
        sortArray(nums);
    }
}
