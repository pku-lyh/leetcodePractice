/*给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。*/
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode node = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = node;
        return root;
    }
}
