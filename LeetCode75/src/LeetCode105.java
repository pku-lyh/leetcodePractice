/*给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。*/
public class LeetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return buildTree(preorder, inorder, 0, n-1, 0, n-1);
    }
    private TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int index = inLeft;
        while (index <= inRight && inorder[index] != preorder[preLeft]) {
            index++;
        }
        root.left = buildTree(preorder, inorder, preLeft+1, index-inLeft+preLeft, inLeft, index-1);
        root.right = buildTree(preorder, inorder, index-inLeft+preLeft+1, preRight, index+1, inRight);
        return root;
    }
}
