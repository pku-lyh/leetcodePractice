/*给你一个单链表的头节点 head ，请你判断该链表是否为
回文链表
。如果是，返回 true ；否则，返回 false 。*/
public class LeetCode234 {
    public boolean isPalindrome(ListNode head) {
        // 快慢指针
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = new ListNode(-1);
        ListNode fast = new ListNode(-1);
        slow.next = head;
        fast.next = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        ListNode post = cur;
        slow.next = null;
        while (cur != null) {
            post = cur.next;
            cur.next = slow.next;
            slow.next = cur;
            cur = post;
        }
        fast = head;
        slow = slow.next;
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
