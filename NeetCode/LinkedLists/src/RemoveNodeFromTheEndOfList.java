public class RemoveNodeFromTheEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null)
        {
            return head;
        }
        int nodeCount = 1;
        ListNode temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
            nodeCount++;
        }
        int deleteNodeCount = nodeCount - n;
        if(deleteNodeCount == 0)
        {
            head = head.next;
            return head;
        }
        int tempCount = 1;
        temp = head;
        while(tempCount < deleteNodeCount)
        {
            temp = temp.next;
            tempCount++;
        }
        if(temp.next.next == null)
        {
            temp.next = null;
            return head;
        }
        else {
            temp.next = temp.next.next;
        }
        return head;
    }
}
