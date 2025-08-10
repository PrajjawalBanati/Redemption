public class ReorderLinkedList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
        {
            return;
        }
        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null || fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode midL = slow;
        ListNode headB = midL.next;
        midL.next = null;
        // Reverse Linked List B
        ListNode revB = null;
        ListNode tempB = headB;
        while(headB!=null)
        {
            headB= headB.next;
            tempB.next = revB;
            revB = tempB;
            tempB = headB;
        }
        ListNode headA = head;
        headB = revB;
        ListNode tempA = headA;
        tempB = revB;
        while(headA!=null && headB!=null)
        {
            headA=headA.next;
            headB=headB.next;
            tempA.next=tempB;
            tempB.next = headA;
            tempA = headA;
            tempB = headB;
        }
    }
}
