/*给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。*/
public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}
