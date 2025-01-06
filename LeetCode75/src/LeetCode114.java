/*给你二叉树的根结点 root ，请你将它展开为一个单链表：
展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。*/
public class LeetCode114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root);
    }

    private TreeNode preOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = preOrder(root.left);
        TreeNode right = preOrder(root.right);
        if (left != null) {
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        // 返回当前根节点的最右节点
        if (right == null && left == null) {
            return root;
        }
        return right == null ? left : right;
    }
}
