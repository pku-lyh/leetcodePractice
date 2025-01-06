/*给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

有效 二叉搜索树定义如下：

节点的左
子树
只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。*/
public class LeetCode98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left) && isValidBST(root.right)){
            if (root.left == null && root.right == null) {
                return true;
            }
            boolean left = true;
            boolean right = true;
            if (root.right != null) {
                TreeNode leftNode = root.right;
                while (leftNode.left!= null) {
                    leftNode = leftNode.left;
                }
                left = root.val < leftNode.val;
            }
            if (root.left != null) {
                TreeNode rightNode = root.left;
                while (rightNode.right!= null) {
                    rightNode = rightNode.right;
                }
                right = root.val > rightNode.val;
            }
            return left && right;
        }
        return false;
    }
}
