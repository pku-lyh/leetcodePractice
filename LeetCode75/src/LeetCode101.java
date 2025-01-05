/*给你一个二叉树的根节点 root ， 检查它是否轴对称。*/
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }
}
