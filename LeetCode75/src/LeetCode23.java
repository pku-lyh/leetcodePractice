import java.util.PriorityQueue;

/*给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。*/
public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        if (len == 1) {
            return lists[0];
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while (!queue.isEmpty()){
            ListNode head = queue.poll();
            cur.next = head;
            cur = cur.next;
            if (head.next != null) {
                queue.add(head.next);
            }
        }
        return ans.next;
    }
}
