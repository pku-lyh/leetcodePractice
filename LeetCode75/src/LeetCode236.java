/**
 * @author pku-lyh
 * @Description 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * @date 2025/1/7 10:47
 */
public class LeetCode236 {
    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean leftSon = dfs(root.left, p, q);
        boolean rightSon = dfs(root.right, p, q);
        if ((leftSon && rightSon) || ((root == p || root == q) && (leftSon || rightSon))) {
            res = root;
        }
        return leftSon || rightSon || root == p || root == q;
    }
}
