public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode tempHead = head;
        ListNode temp = null;
        while(head != null)
        {
            head = head.next;
            tempHead.next = temp;
            temp = tempHead;
        }
        return temp;
    }
}
