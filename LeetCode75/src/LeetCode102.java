import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。*/
public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int pre = 1;
        int cur = 0;
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
            list.add(node.val);
            cur++;
            if(cur == pre) {
                res.add(new ArrayList<>(list));
                list.clear();
                pre = queue.size();
                cur = 0;
            }
        }
        return res;
    }
}
