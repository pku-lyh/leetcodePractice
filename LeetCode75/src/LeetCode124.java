/**
 * @author pku-lyh
 * @Description 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * @date 2025/1/7 10:59
 */
public class LeetCode124 {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left > 0) {
            sum += left;
        }
        if (right > 0) {
            sum += right;
        }
        ans = Math.max(ans, sum);
        return Math.max(left, right) > 0 ? Math.max(left, right) + root.val : root.val;
    }
}
