public class ReverseNodesInKGroup {
    public ListNode[] reverseNodes(ListNode begin, int k)
    {
        ListNode temp = begin;
        while(k > 0)
        {

            k--;
        }
        return null;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 0){
            return head;
        }
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode end = head;
        int a = k;
        while( a > 0)
        {
            end = end.next;
            a--;
        }
        // TODO: think about the logic more
        return null;
    }
}
