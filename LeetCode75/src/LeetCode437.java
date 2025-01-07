/**
 * @author pku-lyh
 * @Description 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * @date 2025/1/7 10:31
 */
public class LeetCode437 {
    int res = 0;
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null){
            return 0;
        }
        dfs(root, targetSum, 0);
        if (root.left != null){
            pathSum(root.left, targetSum);
        }
        if (root.right!= null){
            pathSum(root.right, targetSum);
        }
        return res;
    }

    private void dfs(TreeNode root, long targetSum, long sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (sum == targetSum) {
            res++;
        }
        dfs(root.left, targetSum, sum);
        dfs(root.right, targetSum, sum);
    }
}
