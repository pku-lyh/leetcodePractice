/**
 * @author pku-lyh
 * @Description 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 * <p>
 * 选择二叉树中 任意 节点和一个方向（左或者右）。
 * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 * 改变前进方向：左变右或者右变左。
 * 重复第二步和第三步，直到你在树中无法继续移动。
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 * <p>
 * 请你返回给定树中最长 交错路径 的长度。
 * @date 2025/2/16 10:13
 */
public class LeetCode1372 {
    int res = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        boolean isRight = true;
        dfs(root.left, 1, false);
        dfs(root.right, 1, true);
        return res;
    }

    private void dfs(TreeNode root, int sum, boolean isRight) {
        if (root == null) {
            return;
        }
        res = Math.max(res, sum);
        if (isRight) {
            dfs(root.left, sum + 1, false);
            dfs(root.right, 1, true);
        } else {
            dfs(root.right, sum + 1, true);
            dfs(root.left, 1, false);
        }
    }
}
