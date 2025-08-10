import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> listPriority = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode head = null;
        ListNode temp = head;
        for(ListNode l: lists)
        {
            if(l!=null)
            {
                listPriority.offer(l);
            }
        }
        while(!listPriority.isEmpty())
        {
            ListNode l = listPriority.poll();
            if(head == null)
            {
                head = l;
                temp = l;
            }
            else{
                temp.next = l;
                temp = temp.next;
            }
            if(l.next!= null)
            {
                listPriority.offer(l.next);
            }

        }
        return head;
    }
}
