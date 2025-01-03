/*给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。

k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。*/
public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur;
        ListNode post = head;
        while (post !=null) {
            while (pre.next != null) {
                pre = pre.next;
            }
            for (int i = 0; i < k; i++) {
                // 要头插的节点
                cur = post;
                //说明剩余节点数不够k
                if (cur == null){
                    post = pre.next;
                    pre.next = null;
                    while (post != null) {
                        cur = post;
                        post = cur.next;
                        cur.next = pre.next;
                        pre.next = cur;
                    }
                    break;
                }
                //记录下一个
                post = post.next;
                //头插法
                cur.next = pre.next;
                pre.next = cur;
            }
        }
        return dummy.next;
    }
}
