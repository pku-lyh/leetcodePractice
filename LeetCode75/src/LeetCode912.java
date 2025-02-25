
public class LeetCode912 {
    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return nums;
        }
        int n = nums.length;
        quickSort(nums, 0, n - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1;
        int j = right;
       while (i <= j) {
            while (i <= j && nums[i] <= pivot) {
                i++;
            }
            while (i <= j && nums[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);
        return j;
    }

    private static void swap(int[] nums, int left, int j) {
        int temp = nums[left];
        nums[left] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{110, 100, 0};
        sortArray(nums);
    }
}
