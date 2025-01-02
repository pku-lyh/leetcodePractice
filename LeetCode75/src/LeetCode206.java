/*给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。*/
public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = new ListNode(-1);
        ListNode post = head;
        while (head != null) {
            post = post.next;
            head.next = prev.next;
            prev.next = head;
            head = post;
        }
        return prev.next;
    }
}
