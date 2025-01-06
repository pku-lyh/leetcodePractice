/*给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。*/
public class LeetCode230 {
    int count = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        kthSmallest(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
        }
        kthSmallest(root.right, k);
        return res;
    }
}
