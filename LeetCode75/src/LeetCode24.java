/*给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。*/
public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            prev.next = cur.next;
            cur.next = prev.next.next;
            prev.next.next = cur;
            prev = cur;
            cur = prev.next;
        }
        return dummy.next;
    }
}
