public class AddTwoNumbersInLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int m = 0;
        ListNode templ1 = l1;
        while(templ1!=null)
        {
            m++;
            templ1=templ1.next;
        }
        int n = 0;
        ListNode templ2 = l2;
        while(templ2!=null)
        {
            n++;
            templ2 = templ2.next;
        }
        if(m < n)
        {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        int carry = 0;
        templ1 = l1;
        templ2 = l2;
        while(templ1.next != null && templ2.next !=null)
        {
            int sum = templ1.val + templ2.val + carry;
            carry = sum/10;
            templ1.val = sum%10;
            templ1 = templ1.next;
            templ2 = templ2.next;
        }
        while(templ1.next !=null && carry > 0)
        {
            int sum = templ1.val+carry;
            carry = sum/10;
            templ1.val = sum%10;
            templ1 = templ1.next;
        }
        if(templ1.next == null && carry > 0)
        {
            templ1.next = new ListNode(carry);
        }
        return l1;
    }
}
