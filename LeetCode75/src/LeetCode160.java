/*给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
图示两个链表在节点 c1 开始相交：
题目数据 保证 整个链式结构中不存在环。*/
public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode a = headA, b = headB;
        while (a != b){
           a = a.next;
           b = b.next;
           if (a == null && b != null){
               a = headB;
           }
           if (b == null && a != null){
               b = headA;
           }
        }
        return a;
    }
}
