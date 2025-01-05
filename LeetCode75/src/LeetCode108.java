/*给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵
平衡
 二叉搜索树。*/
public class LeetCode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return sortArray(nums, 0, n - 1);
    }

    private TreeNode sortArray(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortArray(nums, left, mid - 1);
        root.right = sortArray(nums, mid + 1, right);
        return root;
    }
}
