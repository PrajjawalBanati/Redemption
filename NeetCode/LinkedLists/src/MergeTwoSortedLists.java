public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
        {
            return null;
        }
        if(list1 == null)
        {
            return list2;
        }
        if(list2 == null)
        {
            return list1;
        }
        ListNode list3 = null;
        ListNode temp3 = list3;
        while(list1!= null && list2 !=null)
        {
            int val1 = list1.val;
            int val2 = list2.val;
            ListNode temp=null;
            if(val1 >= val2)
            {
                temp = list2;
                list2 = list2.next;
            }
            else {
                temp = list1;
                list1 = list1.next;
            }
            if(list3 == null)
            {
                list3 = temp;
                temp3 = list3;
            }
            else {
                temp3.next = temp;
                temp3 = temp;
            }
        }
        if(list1!=null)
        {
           temp3.next = list1;
        }
        else if(list2!= null)
        {
            temp3.next = list2;
        }
        return list3;
    }
}
